INSERT INTO season (id, name) values (1, 'Spring'), (2, 'Summer'), (3, 'Fall'), (4, 'Winter');

INSERT INTO crop (id, name, seed_cost, seed_sell_price, grow_time, regrowth_time, crops_per_harvest, crop_sell_price, image_url) values
(1, 'Blue Jazz', 30, 15, 7, 0, 1, 50, '/images/crops/Blue_Jazz.png'),
(2, 'Cauliflower', 80, 40, 12, 0, 1, 175, '/images/crops/Cauliflower.png'),
(3, 'Coffee Bean', 2500, 15, 10, 2, 4.02, 15, '/images/crops/Coffee_Bean.png'),
(4, 'Garlic', 40, 20, 4, 0, 1, 60, '/images/crops/Garlic.png'),
(5, 'Green Bean', 60, 30, 10, 3, 1, 40, '/images/crops/Green_Bean.png'),
(6, 'Kale', 70, 35, 6, 0, 1, 110, '/images/crops/Kale.png'),
(7, 'Parsnip', 20, 10, 4, 0, 1, 35, '/images/crops/Parsnip.png'),
(8, 'Potato', 50, 25, 6, 0, 1.25, 80, '/images/crops/Potato.png'),
(9, 'Rhubarb', 100, 50, 13, 0, 1, 220, '/images/crops/Rhubarb.png'),
(10, 'Strawberry', 100, 0, 8, 4, 1.02, 120, '/images/crops/Strawberry.png'),
(11, 'Tulip', 20, 10, 6, 0, 1, 30, '/images/crops/Tulip.png'),
(12, 'Unmilled Rice', 40, 20, 6, 0, 1.5, 30, '/images/crops/Unmilled_Rice.png'),
(13, 'Blueberry', 80, 40, 13, 4, 3.02, 50, '/images/crops/Blueberry.png'),
(14, 'Corn', 150, 75, 14, 4, 1, 50, '/images/crops/Corn.png'),
(15, 'Hops', 60, 30, 11, 1, 1, 25, '/images/crops/Hops.png'),
(16, 'Hot Pepper', 40, 20, 5, 3, 1.03, 40, '/images/crops/Hot_Pepper.png'),
(17, 'Melon', 80, 40, 12, 0, 1, 250, '/images/crops/Melon.png'),
(18, 'Poppy', 100, 50, 7, 0, 1, 140, '/images/crops/Poppy.png'),
(19, 'Radish', 40, 20, 6, 0, 1, 90, '/images/crops/Radish.png'),
(20, 'Red Cabbage', 100, 50, 9, 0, 1, 260, '/images/crops/Red_Cabbage.png'),
(21, 'Starfruit', 400, 200, 13, 0, 1, 750, '/images/crops/Starfruit.png'),
(22, 'Summer Spangle', 50, 25, 8, 0, 1, 90, '/images/crops/Summer_Spangle.png'),
(23, 'Sunflower', 200, 100, 8, 0, 1, 80, '/images/crops/Sunflower.png'),
(24, 'Tomato', 50, 25, 11, 4, 1.05, 60, '/images/crops/Tomato.png'),
(25, 'Wheat', 10, 5, 4, 0, 1, 25, '/images/crops/Wheat.png'),
(26, 'Amaranth', 70, 35, 7, 0, 1, 150, '/images/crops/Amaranth.png'),
(27, 'Artichoke', 30, 15, 8, 0, 1, 160, '/images/crops/Artichoke.png'),
(28, 'Beet', 20, 10, 6, 0, 1, 100, '/images/crops/Beet.png'),
(29, 'Bok Choy', 50, 25, 4, 0, 1, 80, '/images/crops/Bok_Choy.png'),
(30, 'Cranberries', 240, 60, 7, 5, 2.1, 75, '/images/crops/Cranberries.png'),
(31, 'Eggplant', 20, 10, 5, 5, 1.02, 60, '/images/crops/Eggplant.png'),
(32, 'Fairy Rose', 200, 100, 12, 0, 1, 290, '/images/crops/Fairy_Rose.png'),
(33, 'Grape', 60, 30, 10, 3, 1, 80, '/images/crops/Grape.png'),
(34, 'Pumpkin', 100, 50, 13, 0, 1, 320, '/images/crops/Pumpkin.png'),
(35, 'Yam', 60, 30, 10, 0, 1, 160, '/images/crops/Yam.png'),
(36, 'Ancient Fruit', 0, 30, 28, 7, 1, 550, '/images/crops/Ancient_Fruit.png');







INSERT INTO crop_season(crop_id, season_id) values
(1,1),
(2,1),
(3,1),
(3,2),
(4,1),
(5,1),
(6,1),
(7,1),
(8,1),
(9,1),
(10,1),
(11,1),
(12,1),
(13,2),
(14,2),
(14,3),
(15,2),
(16,2),
(17,2),
(18,2),
(19,2),
(20,2),
(21,2),
(22,2),
(23,2),
(23,3),
(24,2),
(25,2),
(25,3),
(26,3),
(27,3),
(28,3),
(29,3),
(30,3),
(31,3),
(32,3),
(33,3),
(34,3),
(35,3),
(36,1),
(36,2),
(36,3);

















