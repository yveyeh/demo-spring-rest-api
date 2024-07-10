DROP TABLE IF EXISTS otp_action_entity_max_attempts;

CREATE TABLE otp_action_entity_max_attempts (
  otp_action_entity_id UUID NOT NULL,
  method VARCHAR(255) NOT NULL,
  max_attempts INT NOT NULL,
  CONSTRAINT unique_attempt_per_method UNIQUE (otp_action_entity_id, method)
);

CREATE TABLE otp_action_entity_templates (
  otp_action_entity_id UUID NOT NULL,
  method VARCHAR(255) NOT NULL,
  templates INT NOT NULL,
  CONSTRAINT _unique_attempt_per_method UNIQUE (otp_action_entity_id, method)
);


ALTER TABLE otp_action_entity_templates ALTER COLUMN templates TYPE text;
