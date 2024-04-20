DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS seat;
DROP TABLE IF EXISTS event;


CREATE TABLE event
(
    id IDENTITY PRIMARY KEY,
    name      VARCHAR(255),
    date_time TIMESTAMP,
    location  VARCHAR(255)
);

CREATE TABLE seat
(
    id IDENTITY PRIMARY KEY,
    number      VARCHAR(255),
    is_reserved BOOLEAN,
    event_id    BIGINT
);

CREATE TABLE reservation
(
    id IDENTITY PRIMARY KEY,
    event_id BIGINT,
    seat_id  BIGINT,
    reservation_date TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES event (id),
    FOREIGN KEY (seat_id) REFERENCES seat (id)
);


INSERT INTO event (id, name, date_time, location)
VALUES (1, 'Rock Concert', '2022-06-01T20:00:00', 'Madison Square Garden'),
       (2, 'Broadway Show', '2022-07-01T19:30:00', 'Broadway Theatre'),
       (3, 'Football Match', '2022-08-01T15:00:00', 'Wembley Stadium');

-- Insert 10 seats for each event
INSERT INTO seat (id, number, is_reserved, event_id)
VALUES (1, 'Seat 1', false, 1),
       (2, 'Seat 2', false, 1),
       (3, 'Seat 3', false, 1),
       (4, 'Seat 4', false, 1),
       (5, 'Seat 5', false, 1),
       (6, 'Seat 6', false, 1),
       (7, 'Seat 7', false, 1),
       (8, 'Seat 8', false, 1),
       (9, 'Seat 9', false, 1),
       (10, 'Seat 10', false, 1),
       (11, 'Seat 1', false, 2),
       (12, 'Seat 2', false, 2),
       (13, 'Seat 3', false, 2),
       (14, 'Seat 4', false, 2),
       (15, 'Seat 5', false, 2),
       (16, 'Seat 6', false, 2),
       (17, 'Seat 7', false, 2),
       (18, 'Seat 8', false, 2),
       (19, 'Seat 9', false, 2),
       (20, 'Seat 10', false, 2),
       (21, 'Seat 1', false, 3),
       (22, 'Seat 2', false, 3),
       (23, 'Seat 3', false, 3),
       (24, 'Seat 4', false, 3),
       (25, 'Seat 5', false, 3),
       (26, 'Seat 6', false, 3),
       (27, 'Seat 7', false, 3),
       (28, 'Seat 8', false, 3),
       (29, 'Seat 9', false, 3),
       (30, 'Seat 10', false, 3);