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
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a857', 'eaa663d1-4eb7-4a9f-9a90-d61c0d82a856', 'Heineken Brewery 1', 'Heineken Brewery Address 1', '51.820054', '4.481172'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a858', 'eaa663d1-4eb7-4a9f-9a90-d61c0d82a856', 'Heineken Brewery 2', 'Heineken Brewery Address 2', '52.479189', '4.899431'),

    -- Brewery 2: Hertog Jan
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a859', '1b92a522-e99d-42e7-925d-7a065d6c9d50', 'Hertog Jan Brewery 1', 'Hertog Jan Brewery Address 1', '52.090737', '5.621420'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85a', '1b92a522-e99d-42e7-925d-7a065d6c9d50', 'Hertog Jan Brewery 2', 'Hertog Jan Brewery Address 2', '51.378670', '5.440262'),

    -- Brewery 3: Kordaat
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85b', 'eec8b7a2-20a2-47da-8c9a-bac8d68a3f5a', 'Kordaat Brewery 1', 'Kordaat Brewery Address 1', '52.155722', '4.202924'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85c', 'eec8b7a2-20a2-47da-8c9a-bac8d68a3f5a', 'Kordaat Brewery 2', 'Kordaat Brewery Address 2', '52.303477', '5.287159'),

    -- Brewery 4: Grolsch
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85d', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Grolsch Brewery 1', 'Grolsch Brewery Address 1', '52.435474', '6.661176'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85e', '7c697a6f-8d4a-4c8b-8e21-7e57fc07316a', 'Grolsch Brewery 2', 'Grolsch Brewery Address 2', '52.331646', '6.696802');

-- Insert locations for supermarkets (5 locations each)
INSERT INTO location (id, organization_id, name, address, latitude, longitude)
VALUES
    -- Supermarket 1: Lidl
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a85f', '3e4bdc4e-51d2-4e82-a05a-93ac3e3a7861', 'Lidl Supermarket 1', 'Lidl Supermarket Address 1', '51.719439', '4.277911'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a860', '3e4bdc4e-51d2-4e82-a05a-93ac3e3a7861', 'Lidl Supermarket 2', 'Lidl Supermarket Address 2', '52.193168', '4.171490'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a861', '3e4bdc4e-51d2-4e82-a05a-93ac3e3a7861', 'Lidl Supermarket 3', 'Lidl Supermarket Address 3', '52.462900', '4.056246'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a862', '3e4bdc4e-51d2-4e82-a05a-93ac3e3a7861', 'Lidl Supermarket 4', 'Lidl Supermarket Address 4', '52.626750', '5.278769'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a863', '3e4bdc4e-51d2-4e82-a05a-93ac3e3a7861', 'Lidl Supermarket 5', 'Lidl Supermarket Address 5', '52.477077', '4.192023'),

    -- Supermarket 2: Aldi
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a864', '9c24c37b-6a5b-4c5a-8b4e-0b3a5a8f385d', 'Aldi Supermarket 1', 'Aldi Supermarket Address 1', '51.560131', '4.874955'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a865', '9c24c37b-6a5b-4c5a-8b4e-0b3a5a8f385d', 'Aldi Supermarket 2', 'Aldi Supermarket Address 2', '52.271514', '4.503863'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a866', '9c24c37b-6a5b-4c5a-8b4e-0b3a5a8f385d', 'Aldi Supermarket 3', 'Aldi Supermarket Address 3', '51.525150', '4.776442'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a867', '9c24c37b-6a5b-4c5a-8b4e-0b3a5a8f385d', 'Aldi Supermarket 4', 'Aldi Supermarket Address 4', '52.823367', '4.890799'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a868', '9c24c37b-6a5b-4c5a-8b4e-0b3a5a8f385d', 'Aldi Supermarket 5', 'Aldi Supermarket Address 5', '51.677177', '4.530216'),

    -- Supermarket 3: Albert Heijn
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a869', '8318c3b0-590c-4845-8cb9-d30d2f344edb', 'Albert Heijn Supermarket 1', 'Albert Heijn Supermarket Address 1', '51.679084', '4.586695'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a86a', '8318c3b0-590c-4845-8cb9-d30d2f344edb', 'Albert Heijn Supermarket 2', 'Albert Heijn Supermarket Address 2', '52.591010', '4.723285'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a86b', '8318c3b0-590c-4845-8cb9-d30d2f344edb', 'Albert Heijn Supermarket 3', 'Albert Heijn Supermarket Address 3', '51.413678', '4.794666'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a86c', '8318c3b0-590c-4845-8cb9-d30d2f344edb', 'Albert Heijn Supermarket 4', 'Albert Heijn Supermarket Address 4', '51.619146', '4.577397'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a86d', '8318c3b0-590c-4845-8cb9-d30d2f344edb', 'Albert Heijn Supermarket 5', 'Albert Heijn Supermarket Address 5', '52.266029', '4.878873'),

    -- Supermarket 4: Hoogvliet
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a86e', 'd1408c98-878d-4d2a-b5c5-370fea22d312', 'Hoogvliet Supermarket 1', 'Hoogvliet Supermarket Address 1', '51.407871', '4.596234'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a86f', 'd1408c98-878d-4d2a-b5c5-370fea22d312', 'Hoogvliet Supermarket 2', 'Hoogvliet Supermarket Address 2', '51.947613', '4.822633'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a870', 'd1408c98-878d-4d2a-b5c5-370fea22d312', 'Hoogvliet Supermarket 3', 'Hoogvliet Supermarket Address 3', '51.496180', '4.527676'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a871', 'd1408c98-878d-4d2a-b5c5-370fea22d312', 'Hoogvliet Supermarket 4', 'Hoogvliet Supermarket Address 4', '52.161728', '4.537832'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a872', 'd1408c98-878d-4d2a-b5c5-370fea22d312', 'Hoogvliet Supermarket 5', 'Hoogvliet Supermarket Address 5', '52.329383', '4.840700'),

    -- Supermarket 5: Jumbo
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a873', 'c84e07cc-0d42-44a5-8363-afde90302e9a', 'Jumbo Supermarket 1', 'Jumbo Supermarket Address 1', '51.920788', '4.696545'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a874', 'c84e07cc-0d42-44a5-8363-afde90302e9a', 'Jumbo Supermarket 2', 'Jumbo Supermarket Address 2', '51.978423', '5.364862'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a875', 'c84e07cc-0d42-44a5-8363-afde90302e9a', 'Jumbo Supermarket 3', 'Jumbo Supermarket Address 3', '52.026688', '5.246085'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a876', 'c84e07cc-0d42-44a5-8363-afde90302e9a', 'Jumbo Supermarket 4', 'Jumbo Supermarket Address 4', '51.986324', '5.018581'),
    ('eaa663d1-4eb7-4a9f-9a90-d61c0d82a877', 'c84e07cc-0d42-44a5-8363-afde90302e9a', 'Jumbo Supermarket 5', 'Jumbo Supermarket Address 5', '52.058143', '4.417691');