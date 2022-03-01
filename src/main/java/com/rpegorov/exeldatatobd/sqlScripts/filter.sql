-- all product
select * from product

-- all product where p.type QOIL
select p.product_type, p.amount
from product p
where product_type = 'QOIL'

-- all product where p.type QOIL
select p.product_type, p.amount
from product p
where product_type = 'QLIQ'

-- all product where p.type QOIL
select p.product_type, p.amount, p.date
from product p
where product_type = 'QOIL'


-- avg amount where p_type QOIL
select avg(p.amount)
from product p
where product_type = 'QOIL'

-- avg amount where p_type QLIQ
select avg(p.amount)
from product p
where product_type = 'QLIQ'

select * from product p
where p.product_type = 'QOIL'

select p.product_type, p.amount
from product p
where product_type = 'QOIL'


select p.product_type, p.amount
from product p
where product_type = 'QLIQ'

select p.product_type, p.amount, p.date
from product p
where product_type = 'QOIL'

select avg(p.amount)
from product p
where product_type = 'QOIL'

select avg(p.amount)
from product p
where product_type = 'QLIQ'

-- products by date 2019-01-14
select p.amount, p.product_type, p.date
from product p
where p.date = '2019-01-14'

-- products by date 2021-02-28
select p.amount, p.product_type, p.date, o.company
from product p join orders o on p.order_id = o.id
where p.date = '2021-02-28'

-- product by data_type FORECAST
select p.amount, p.date, o.company, p.data_type
from product p join orders o on p.order_id = o.id
where p.data_type = 'FORECAST'

-- product by data_type FACT
select p.amount, p.date, o.company, p.data_type
from product p join orders o on p.order_id = o.id
where p.data_type = 'FACT'

-- all products company1
select o.company, p.amount, product_type, p.data_type, p.date
from orders o join product p on o.id = p.order_id
where o.company like 'company1'

-- all products company2
select o.company, p.amount, product_type, p.data_type, p.date
from orders o join product p on o.id = p.order_id
where o.company like 'company2'

-- sum product type QLIQ
select sum(p.amount), p.data_type, p.product_type
from product p
where product_type = 'QLIQ'
group by p.data_type, p.product_type

-- sum product type QOIL
select sum(p.amount), p.data_type, p.product_type
from product p
where product_type = 'QOIL'
group by p.data_type, p.product_type

-- sum data type FORECAST
select sum(p.amount), p.data_type, p.product_type
from product p
where data_type = 'FORECAST'
group by p.data_type, p.product_type

-- sum data type FACT
select sum(p.amount), p.data_type, p.product_type
from product p
where data_type = 'FACT'
group by p.data_type, p.product_type

-- sum data type FORECAST and product type QOIL
select sum(p.amount), p.data_type, p.product_type
from product p
where data_type = 'FORECAST' and product_type = 'QOIL'
group by p.data_type, p.product_type

-- sum data type FORECAST and product type QLIQ
select sum(p.amount), p.data_type, p.product_type
from product p
where data_type = 'FORECAST' and product_type = 'QLIQ'
group by p.data_type, p.product_type

-- sum data type FACT and product type QLIQ
select sum(p.amount), p.data_type, p.product_type
from product p
where data_type = 'FACT' and product_type = 'QLIQ'
group by p.data_type, p.product_type

-- sum data type FACT and product type QOIL
select sum(p.amount), p.data_type, p.product_type
from product p
where data_type = 'FACT' and product_type = 'QOIL'
group by p.data_type, p.product_type