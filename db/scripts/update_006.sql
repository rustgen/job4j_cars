
CREATE TABLE IF NOT EXISTS engine (
id SERIAL PRIMARY KEY,
name TEXT
);

CREATE TABLE IF NOT EXISTS car (
id SERIAL PRIMARY KEY,
name TEXT,
photo BYTEA,
engine_id INT not null unique REFERENCES engine(id)
);

CREATE TABLE IF NOT EXISTS driver (
id SERIAL PRIMARY KEY,
name TEXT,
user_id INT not null unique REFERENCES auto_user(id)
);

CREATE TABLE IF NOT EXISTS history_owner (
     id SERIAL PRIMARY KEY,
     driver_id INT not null REFERENCES driver(id),
     car_id INT not null REFERENCES car(id),
     startAt VARCHAR,
     endAt VARCHAR
);
