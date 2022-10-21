CREATE TABLE IF NOT EXISTS auto_post (
   id SERIAL PRIMARY KEY,
   text TEXT,
   created TIMESTAMP,
   auto_user_id INT REFERENCES auto_user(id)
);
