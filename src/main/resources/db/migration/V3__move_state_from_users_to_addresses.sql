ALTER TABLE users
    DROP COLUMN state;

ALTER TABLE addresses
    ADD COLUMN state VARCHAR(255);