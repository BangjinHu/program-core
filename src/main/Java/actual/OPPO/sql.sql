
select c.city_name
from city_info c
join
(
select b.city_id from
(select store_id, count(1) as count_num from order_detail where store_id in (
select store_id from order_detail
)
group by
    store_id
) a
join

(select store_id, city_id from store_info) b on a.store_id = b.store_id

) on d on c.city_id = d.city_id

