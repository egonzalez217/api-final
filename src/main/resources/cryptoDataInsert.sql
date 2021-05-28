use crypto;

INSERT INTO crypto_exchange (exchange_id, exchange_name)
VALUES
(1, 'Coinbase'),
(2, 'Binance'),
(3, 'Bybit'),
(4, 'Swissborg'),
(5, 'Gemini');

INSERT INTO blockchain (blockchain_id, blockchain_name)
VALUES
(1, 'Bitcoin'),
(2, 'Ethereum');

INSERT INTO crypto_user (user_id, user_name, is_miner)
VALUES
(1, 'Emilio', 'Miner'),
(2, 'Cruz', ''),
(3, 'Elon Musk', ''),
(4, 'WallStreetBets', ''),
(5, 'Bill Gates', 'Miner'),
(6, 'Michael Saylor', 'Miner'),
(7, 'Vitalik', 'Miner'),
(8, 'Martini Guy', 'Miner'),
(9, 'Bre', ''),
(10, 'Sabrina', '');

INSERT INTO crypto_token (token_id, crypto_id, crypto_name, bid, ask)
VALUES
(1, 1, 'Bitcoin', 43000, 43850),
(2, 2, 'Ethereum', 2500, 2700),
(3, 2, 'Binance', 385, 387),
(4, 2, 'Uniwap', 25, 27),
(5, 2, 'VeChain', 1, 2);

INSERT INTO wallet (wallet_id, crypto_id, price_bought_at)
VALUES
(1, 1, 12),
(2, 2, 20),
(3, 3, 300),
(4, 4, 10),
(5, 5, 1),
(6, 1, 35000),
(7, 2, 2000),
(8, 3, 350),
(9, 4, 22),
(10, 5, 1);