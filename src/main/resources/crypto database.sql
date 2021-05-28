create database if not exists crypto;

use crypto;

drop table if exists wallet;
drop table if exists crypto_token;
drop table if exists crypto_user;
drop table if exists blockchain;
drop table if exists crypto_exchange;

CREATE TABLE crypto_exchange
(
	exchange_id int(10) not null auto_increment,
	exchange_name varchar(20) not null,
	primary key (exchange_id)
);

CREATE TABLE blockchain
(
	blockchain_id int(10) not null auto_increment,
	blockchain_name varchar(20) not null,
	primary key (blockchain_id)
);

CREATE TABLE crypto_user
(
	user_id int(10) not null auto_increment,
	user_name varchar(16) not null,
	is_miner varchar(5),
	primary key (user_id)
);

CREATE TABLE  crypto_token
(
	token_id int(10) not null auto_increment,
	crypto_id int(10) not null,
    crypto_name varchar(16) not null,
	bid int(15) not null,
	ask int(15) not null,
	primary key (token_id, crypto_id),
	foreign key (token_id) references crypto_exchange (exchange_id),
	foreign key (crypto_id) references blockchain (blockchain_id)
);

CREATE TABLE wallet
(
	wallet_id int(10) not null auto_increment,
	crypto_id int(10) not null,
	price_bought_at int(10) not null,
	primary key (wallet_id, crypto_id),
	foreign key (wallet_id) references crypto_user (user_id),
	foreign key (crypto_id) references crypto_token (token_id)
);