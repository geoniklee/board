INSERT INTO article(id, title, content) VALUES (1, '1111', 'aaaa');
INSERT INTO article(id, title, content) VALUES (2, '2222', 'bbbb');
INSERT INTO article(id, title, content) VALUES (3, '3333', 'cccc');


--article dummy data
INSERT INTO article(id, title, content) VALUES (4, '4444', 'dddd');
INSERT INTO article(id, title, content) VALUES (5, '5555', 'eeee');
INSERT INTO article(id, title, content) VALUES (6, '6666', 'ffff');

-- 22강: comment 더미 데이터
---- 4번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES(1, 4, 'Park', 'Good will hunting');
INSERT INTO comment(id, article_id, nickname, body) VALUES(2, 4, 'Kim', 'I am sam');
INSERT INTO comment(id, article_id, nickname, body) VALUES(3, 4, 'Choi', 'showsank');
---- 5번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 5, 'Park', 'chicken');
INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 5, 'Kim', 'soup');
INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 5, 'Choi', 'sushi');
---- 6번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 6, 'Park', 'jogging');
INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 6, 'Kim', 'youtube');
INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 6, 'Choi', 'reading');
