use telecom_platform;

insert into telecom_plan(
    name, monthly_fee_fen, data_gb, status
) values
     ('畅享39元套餐', 3900, 20, 'ON_SALE'),
     ( '畅享79元套餐', 7900, 60, 'ON_SALE'),
     ( '经典19元套餐', 1900, 5, 'OFF_SALE');

select * from telecom_plan;

update telecom_plan set data_gb =30 where id=1