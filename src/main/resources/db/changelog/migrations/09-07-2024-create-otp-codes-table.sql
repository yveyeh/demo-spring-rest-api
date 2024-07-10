CREATE TABLE otp_codes (
  id SERIAL PRIMARY KEY,
  value VARCHAR(255) NOT NULL,
  expires_at TIMESTAMP WITH TIME ZONE NOT NULL,
  methods JSONB NOT NULL,
  attempts JSONB NOT NULL,
  messages JSONB NOT NULL,
  recipient VARCHAR(255) NOT NULL,
  is_invalid BOOLEAN DEFAULT FALSE NOT NULL,
  otp_action_id UUID,
  user_id UUID,
  CONSTRAINT fk_otp_codes_otp_action_id FOREIGN KEY (otp_action_id) REFERENCES otp_actions(id) ON DELETE SET NULL,
  CONSTRAINT fk_otp_codes_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);
