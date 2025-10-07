-- Create a user for NiFi with a password
CREATE USER nifi WITH PASSWORD 'nifi-password';

-- Grant access to an existing database
GRANT CONNECT ON DATABASE reporting_data TO nifi;

-- Once inside the DB, grant privileges on public schema and tables
\connect reporting_data

-- Allow NiFi to use schema, and access/modify data
GRANT USAGE ON SCHEMA public TO nifi;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO nifi;

-- Allow access to future tables
ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO nifi;