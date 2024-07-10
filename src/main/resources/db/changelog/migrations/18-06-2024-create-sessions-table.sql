CREATE TABLE sessions (
  id UUID PRIMARY KEY NOT NULL, -- Use generated UUID for primary key
  token VARCHAR(255) NOT NULL UNIQUE, -- Session token (unique)
  last_seen TIMESTAMP WITH TIME ZONE NOT NULL, -- Last seen timestamp
  expires TIMESTAMP WITH TIME ZONE NOT NULL, -- Expiration timestamp
  is_valid BOOLEAN DEFAULT TRUE NOT NULL, -- Validity flag
  user_id UUID NOT NULL, -- REFERENCES users(id), -- Foreign key to user table

  -- Embedded IP Address fields
  ip_address_value VARCHAR(255) NOT NULL, -- Actual IP address string
  ip_address_provider VARCHAR(255), -- Optional provider information
  ip_address_dns VARCHAR(255), -- Optional DNS information
  ip_address_zip_code VARCHAR(255), -- Optional zip code information

  -- Embedded Browser fields
  browser_name VARCHAR(255), -- Browser name
  browser_version VARCHAR(255), -- Browser version
  browser_arch VARCHAR(255), -- Browser architecture
  browser_accept_language VARCHAR(255), -- Preferred language(s)
  browser_user_agent VARCHAR(255), -- User agent string

  -- Embedded Device fields
  device_manufacturer VARCHAR(255), -- Device manufacturer
  device_model VARCHAR(255), -- Device model

  -- Embedded Operating System fields
  operating_system_maker VARCHAR(255), -- Operating system maker
  operating_system_name VARCHAR(255) -- Operating system name
);
