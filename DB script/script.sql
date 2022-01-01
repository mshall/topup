-- public.customers definition

-- Drop table

-- DROP TABLE public.customers;

CREATE TABLE public.customers (
	id varchar NOT NULL DEFAULT nextval('customers_customerid_seq'::regclass),
	"name" varchar(255) NULL,
	email varchar(255) NULL
);


-- public.currency definition

-- Drop table

-- DROP TABLE public.currency;

CREATE TABLE public.currency (
	id int4 NOT NULL DEFAULT nextval('currency_currencyid_seq'::regclass),
	"name" varchar(255) NULL,
	symbol varchar(5) NULL,
	value float8 NULL
);


-- public.transactions definition

-- Drop table

-- DROP TABLE public.transactions;

CREATE TABLE public.transactions (
	customer_id varchar NULL,
	fees_amount float8 NULL,
	fees_currency_id int4 NULL,
	final_amount float8 NULL,
	charge_id varchar NULL,
	status varchar NULL,
	created timestamp(0) NULL,
	transaction_id serial NOT NULL
);


-- public.wallets definition

-- Drop table

-- DROP TABLE public.wallets;

CREATE TABLE public.wallets (
	wallet_id varchar(255) NOT NULL DEFAULT nextval('wallets_walletid_seq'::regclass),
	customer_id varchar NULL,
	currency_id int4 NULL,
	balance float8 NULL
);


INSERT INTO public.currency
("name", symbol, value, id)
VALUES('USD', '$', 1, 1);
VALUES('KWD', '$', 4, 2);
VALUES('AED', '$', 0.27, 3);
VALUES('EGP', '$', 0.12, 4);
