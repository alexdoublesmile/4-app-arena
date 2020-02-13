DROP TABLE IF EXISTS a_player;

CREATE TABLE a_player (
  player_id SERIAL,
  player_first_name varchar not null,
  player_last_name varchar not null,
  player_login varchar not null,
  player_password varchar not null,
  player_score integer,
  PRIMARY KEY(player_id)
);

CREATE INDEX idx_player_id ON a_player(player_id);
