import { type RemovableRef, useSessionStorage } from "@vueuse/core";
import { defineStore, storeToRefs } from "pinia";
import { Connection, ConnectionAddress } from "~/types/Connection/Connection";
import { v4 as uuidv4 } from 'uuid';

import { useUserStore } from "../user/userStore";

export const useConnectionStore = defineStore("authenticatedServer", () => {

    const connections : RemovableRef<Connection[]> = useSessionStorage<Connection[]>("connections", [] as Connection[])

    const userStore = useUserStore();

    const { user } = storeToRefs(userStore);

    async function authenticate(){
        let address = ""
        let port = 0
        if (process.client) {
            const location = window.location.href
            address = location.substring(7,16)
            port = Number(location.substring(17,21))

            user.value.address = address;
            user.value.port = port;
        }
        const newConnecttion: Connection = <Connection>{
            address: {
                address: address,
                port: port
            },
            server: {
                origin: {
                    name: uuidv4(),
                    id: uuidv4()
                },
                institution: {
                    name: uuidv4(),
                    id: uuidv4()
                }
            }
        } as Connection
        const { data } = await useAsyncData<Connection[]>('connections', () => $fetch(`http://${user.value.address}:${user.value.port}/api/authenticate`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: newConnecttion
        }))

        console.log(data)

        if(data.value == null){
            return
        }
        connections.value.push(...data.value)

    }

    async function connect(address: ConnectionAddress){
        const { data } = await useAsyncData<Connection[]>('connections', () => $fetch(`http://${address.address}:${address.port}/api/connect`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
              },
            body: {
                connection: {
                    source: {
                        address: user.value.address,
                        port: user.value.port
                    },
                    target: address,
                    connections: connections.value
                }
            }
        }));

        if(data === undefined){
            return
        }
        if(data.value !== null){
            connections.value = data.value
        }


  }
    return {
        connections, connect,authenticate
    }
},
{
    persist: false
})