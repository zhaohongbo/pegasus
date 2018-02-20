CREATE TABLE public."user"
(
  uid SERIAL PRIMARY KEY NOT NULL,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX user_username_uindex ON public."user" (username);
COMMENT ON COLUMN public."user".uid IS '用户id';
COMMENT ON COLUMN public."user".username IS '用户名';
COMMENT ON COLUMN public."user".password IS '密码';
COMMENT ON TABLE public."user" IS '基础用户表';