CREATE TABLE leads (
                       id BINARY(16) NOT NULL PRIMARY KEY,
                       full_name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       phone VARCHAR(255) NOT NULL,
                       company_name VARCHAR(255),
                       notes TEXT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
