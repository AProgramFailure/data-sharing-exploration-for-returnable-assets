-- Insert breweries
INSERT INTO organization (id, name, organization_type)
VALUES
    ('7c697a6f-8d4a-4c8b-8e21-7e57fc07316a','Grolsch','BREWERY'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a856', 'Heineken', 'BREWERY'),
    ('1b92a522-e99d-42e7-925d-7a065d6c9d50', 'Hertog Jan', 'BREWERY'),
    ('eec8b7a2-20a2-47da-8c9a-bac8d68a3f5a', 'Kordaat', 'BREWERY');

-- Insert supermarkets
INSERT INTO organization (id, name, organization_type)
VALUES
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7861', 'Lidl', 'SUPERMARKET'),
    ('9c24c37b-6a5b-4c5a-8b4e-0b3a5a8f385d', 'Aldi', 'SUPERMARKET'),
    ('8318c3b0-590c-4845-8cb9-d30d2f344edb', 'Albert Heijn', 'SUPERMARKET'),
    ('d1408c98-878d-4d2a-b5c5-370fea22d312', 'Hoogvliet', 'SUPERMARKET'),
    ('c84e07cc-0d42-44a5-8363-afde90302e9a', 'Jumbo', 'SUPERMARKET');

-- Insert locations for breweries (2 locations each)
INSERT INTO location (id, organization_id, name, address, latitude, longitude)
VALUES
    -- Brewery 1: Heineken
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a856', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Heineken Brewery 1', 'Heineken Brewery Address 1', '51.820054', '4.481172'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7861', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Heineken Brewery 2', 'Heineken Brewery Address 2', '52.479189', '4.899431'),

    -- Brewery 2: Hertog Jan
    ('1b92a522-e99d-42e7-925d-7a065d6c9d50', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Hertog Jan Brewery 1', 'Hertog Jan Brewery Address 1', '52.090737', '5.621420'),
    ('4b7a7be2-e99d-42e7-925d-7a065d6c9d51', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Hertog Jan Brewery 2', 'Hertog Jan Brewery Address 2', '51.378670', '5.440262'),

    -- Brewery 3: Kordaat
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85b', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Kordaat Brewery 1', 'Kordaat Brewery Address 1', '52.155722', '4.202924'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7866', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Kordaat Brewery 2', 'Kordaat Brewery Address 2', '52.303477', '5.287159'),
    -- Brewery 4: Grolsch
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85c', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Grolsch Brewery 1', 'Grolsch Brewery Address 1', '52.435474', '6.661176'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7867', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Grolsch Brewery 2', 'Grolsch Brewery Address 2', '52.331646', '6.696802');

-- Insert locations for supermarkets (5 locations each)
INSERT INTO location (id, organization_id, name, address, latitude, longitude)
VALUES
    -- Supermarket 1: Lidl
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a857', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Lidl Supermarket 1', 'Lidl Supermarket Address 1', '51.719439', '4.277911'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7862', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Lidl Supermarket 2', 'Lidl Supermarket Address 2', '52.193168', '4.171490'),
    ('8318c3b0-590c-4845-8cb9-d30d2f344edc', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Lidl Supermarket 3', 'Lidl Supermarket Address 3', '52.462900', '4.056246'),
    ('d1408c98-878d-4d2a-b5c5-370fea22d313', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Lidl Supermarket 4', 'Lidl Supermarket Address 4', '52.626750', '5.278769'),
    ('c84e07cc-0d42-44a5-8363-afde90302e9b', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Lidl Supermarket 5', 'Lidl Supermarket Address 5', '52.477077', '4.192023'),

    -- Supermarket 2: Aldi
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a858', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Aldi Supermarket 1', 'Aldi Supermarket Address 1', '51.560131', '4.874955'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7863', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Aldi Supermarket 2', 'Aldi Supermarket Address 2', '52.271514', '4.503863'),
    ('8318c3b0-590c-4845-8cb9-d30d2f344edd', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Aldi Supermarket 3', 'Aldi Supermarket Address 3', '51.525150', '4.776442'),
    ('d1408c98-878d-4d2a-b5c5-370fea22d314', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Aldi Supermarket 4', 'Aldi Supermarket Address 4', '52.823367', '4.890799'),
    ('c84e07cc-0d42-44a5-8363-afde90302e9c', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Aldi Supermarket 5', 'Aldi Supermarket Address 5', '51.677177', '4.530216'),

    -- Supermarket 3: Albert Heijn
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a859', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Albert Heijn Supermarket 1', 'Albert Heijn Supermarket Address 1', '51.679084', '4.586695'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7864', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Albert Heijn Supermarket 2', 'Albert Heijn Supermarket Address 2', '52.591010', '4.723285'),
    ('8318c3b0-590c-4845-8cb9-d30d2f344ede', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Albert Heijn Supermarket 3', 'Albert Heijn Supermarket Address 3', '51.413678', '4.794666'),
    ('d1408c98-878d-4d2a-b5c5-370fea22d315', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Albert Heijn Supermarket 4', 'Albert Heijn Supermarket Address 4', '51.619146', '4.577397'),
    ('c84e07cc-0d42-44a5-8363-afde90302e9d', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Albert Heijn Supermarket 5', 'Albert Heijn Supermarket Address 5', '52.266029', '4.878873'),

    -- Supermarket 4: Hoogvliet
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85a', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Hoogvliet Supermarket 1', 'Hoogvliet Supermarket Address 1', '51.407871', '4.596234'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7865', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Hoogvliet Supermarket 2', 'Hoogvliet Supermarket Address 2', '51.947613', '4.822633'),
    ('8318c3b0-590c-4845-8cb9-d30d2f344edf', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Hoogvliet Supermarket 3', 'Hoogvliet Supermarket Address 3', '51.496180', '4.527676'),
    ('d1408c98-878d-4d2a-b5c5-370fea22d316', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Hoogvliet Supermarket 4', 'Hoogvliet Supermarket Address 4', '52.161728', '4.537832'),
    ('c84e07cc-0d42-44a5-8363-afde90302e9e', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Hoogvliet Supermarket 5', 'Hoogvliet Supermarket Address 5', '52.329383', '4.840700'),

    -- Supermarket 5: Jumbo
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85d', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Jumbo Supermarket 1', 'Jumbo Supermarket Address 1', '51.920788', '4.696545'),
    ('3e4bdc4e-51d2-4e82-a05a-93ac3e3a7868', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Jumbo Supermarket 2', 'Jumbo Supermarket Address 2', '51.978423', '5.364862'),
    ('8318c3b0-590c-4845-8cb9-d30d2f344ee0', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Jumbo Supermarket 3', 'Jumbo Supermarket Address 3', '52.026688', '5.246085'),
    ('d1408c98-878d-4d2a-b5c5-370fea22d317', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Jumbo Supermarket 4', 'Jumbo Supermarket Address 4', '51.986324', '5.018581'),
    ('c84e07cc-0d42-44a5-8363-afde90302e9f', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Jumbo Supermarket 5', 'Jumbo Supermarket Address 5', '52.058143', '4.417691');
