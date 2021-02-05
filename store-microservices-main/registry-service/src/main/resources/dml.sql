INSERT INTO payment_service.bank (id,name) VALUES(1,'BBVA');
INSERT INTO payment_service.bank (id,name) VALUES(2,'Bancomer');

INSERT INTO payment_service.card (id,cvv,exp_date,id_customer , number, bank_id) VALUES(1,'123', '2011-04-28', 3, '3080',1);
INSERT INTO payment_service.card (id,cvv,exp_date,id_customer , number, bank_id) VALUES(2,'321', '2012-05-28', 2, '308880',1);
INSERT INTO payment_service.card (id,cvv,exp_date,id_customer , number, bank_id) VALUES(3,'12345', '2011-07-16', 3, '4453080',1);


