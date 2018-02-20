CREATE TABLE public.user_info
(
  uid SERIAL PRIMARY KEY NOT NULL,
  uid INT NOT NULL,
  nickname VARCHAR(20)
);
CREATE UNIQUE INDEX user_info_uid_uindex ON public.user_info (uid);
COMMENT ON COLUMN public.user_info.uid IS '用户id';
COMMENT ON COLUMN public.user_info.nickname IS '昵称';
COMMENT ON TABLE public.user_info IS '用户信息';