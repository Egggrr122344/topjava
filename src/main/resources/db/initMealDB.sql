DROP TABLE IF EXISTS meals;

ALTER SEQUENCE global_seq RESTART WITH 100000;

CREATE TABLE meals (
    id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    dateTime TIMESTAMP DEFAULT now() NOT NULL,
    description VARCHAR NOT NULL,
    calories INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE


);

create UNIQUE INDEX meal_user_unique_date_time ON meals(user_id, dateTime);

