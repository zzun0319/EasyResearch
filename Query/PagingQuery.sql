SELECT @rownum:=@rownum+1 as no, rsh.* FROM research rsh WHERE (@rownum:=0)=0; 

-- 이거 새 문법 쓰려면 연구 20개 정도 등록해서 테스트해야해
-- research, timeslot 페이징 해야해 (페이징 필요한 곳: 지도교수 메뉴 중 학생들 연구 쭉 뜨도록, 학부생들 타임슬롯 쭉 보일때) 일단 이렇게 두 군데만 하자

