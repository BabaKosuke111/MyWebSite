CREATE TABLE deck (id SERIAL PRIMARY KEY,deck_name varchar(255) not null,deck_class_id int(11) not null,user_id int(11) not null,vote_count int(11) not null)