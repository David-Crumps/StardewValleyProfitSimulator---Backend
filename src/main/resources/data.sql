INSERT INTO season (id, name) values (1, 'Spring'), (2, 'Summer'), (3, 'Fall'), (4, 'Winter');

INSERT INTO crop (id, name, seed_cost, seed_sell_price, grow_time, regrowth_time, crops_per_harvest, crop_sell_price, image_url) values
(1, 'Blue Jazz', 30, 15, 7, 0, 1, 50, '/images/crops/Blue_Jazz.png'),
(2, 'Cauliflower', 80, 40, 12, 0, 1, 175, '/images/crops/Cauliflower.png'),
(3, 'Coffee Bean', 2500, 15, 10, 2, 4.02, 15, '/images/crops/Coffee_Bean.png'),
(4, 'Garlic', 40, 20, 4, 0, 1, 60, '/images/crops/Garlic.png'),
(5, 'Green Bean', 60, 30, 10, 3, 1, 40, '/images/crops/Green_Bean.png'),
(6, 'Kale', 70, 35, 6, 0, 1, 110, '/images/crops/Kale.png');

INSERT INTO crop_season(crop_id, season_id) values
(1,1),
(1,2),
(2,1),
(3,2),
(4,2),
(5,3),
(6,3);