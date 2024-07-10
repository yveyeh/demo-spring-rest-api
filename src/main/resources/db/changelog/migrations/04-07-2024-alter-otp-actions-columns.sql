-- templates column
ALTER TABLE otp_actions ALTER COLUMN templates TYPE TEXT;
ALTER TABLE otp_actions ALTER COLUMN templates DROP DEFAULT;
ALTER TABLE otp_actions ALTER COLUMN templates SET NOT NULL;

-- max_attempts column
ALTER TABLE otp_actions ALTER COLUMN max_attempts TYPE TEXT;
ALTER TABLE otp_actions ALTER COLUMN max_attempts DROP DEFAULT;
ALTER TABLE otp_actions ALTER COLUMN max_attempts SET NOT NULL;
