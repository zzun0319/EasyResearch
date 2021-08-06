SELECT @rownum:=@rownum+1 as no, rsh.* FROM research rsh WHERE (@rownum:=0)=0; 

-- 이거 새 문법 쓰려면 연구 20개 정도 등록해서 테스트해야해
-- research, timeslot 페이징 해야해 (페이징 필요한 곳: 지도교수 메뉴 중 학생들 연구 쭉 뜨도록, 학부생들 타임슬롯 쭉 보일때) 일단 이렇게 두 군데만 하자

-- 더 간단한 방법
SELECT * FROM research ORDERS LIMIT 10;

SELECT * FROM research ORDERS LIMIT 10 OFFSET 5;

SELECT rsch.* FROM
(
SELECT * FROM research ORDER BY research_id DESC
)rsch
LIMIT 10;

SELECT rsch.* FROM
(
SELECT * FROM research ORDER BY research_id DESC
)rsch
LIMIT 10 OFFSET 5;

SELECT r.*, u.user_id, u.user_name FROM research r
JOIN er_users u ON r.researcher = u.user_id
WHERE u.major = '응용인지심리' AND u.user_type IN ('석사과정대학원생', '박사과정대학원생')
ORDER BY research_id DESC
LIMIT 10 OFFSET 5;

SELECT r.*, u.user_id, u.user_name FROM research r
JOIN er_users u ON r.researcher = u.user_id
WHERE u.major = '응용인지심리' AND u.user_type IN ('석사과정대학원생', '박사과정대학원생')
ORDER BY research_id DESC
LIMIT 10 OFFSET 0;


