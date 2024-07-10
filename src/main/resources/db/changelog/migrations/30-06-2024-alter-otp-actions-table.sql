DROP TABLE IF EXISTS otp_actions;

CREATE TABLE otp_actions (
  id UUID PRIMARY KEY,  -- Generate UUID on insert
  slug VARCHAR(255) NULL,
  title VARCHAR(255) NULL,
  description TEXT NULL,
  name VARCHAR(255) NOT NULL, -- Name of the OTP action
  type VARCHAR(255) NOT NULL,  -- Assuming OTP type is stored as string
  format VARCHAR(255) NOT NULL,  -- Assuming OTP format is stored as string
  authorized_methods JSON NOT NULL DEFAULT '[]',  -- Store authorized methods as JSON array
  duration INT NOT NULL,
  templates JSON NOT NULL DEFAULT '{}',  -- Store templates as JSON object
  max_attempts JSON NOT NULL DEFAULT '{}',  -- Store max attempts per method as JSON object
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL,
  UNIQUE (name, type, format)  -- Unique constraint for combination of name, type, and format
);