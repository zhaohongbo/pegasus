CREATE TABLE public.geo_data
(
  id SERIAL PRIMARY KEY NOT NULL,
  longitude FLOAT,
  latitude FLOAT,
  value FLOAT,
  name VARCHAR(20),
  create_at TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX geo_data_create_at_uindex ON public.geo_data (create_at);
COMMENT ON COLUMN public.geo_data.longitude IS '经度';
COMMENT ON COLUMN public.geo_data.latitude IS '纬度';
COMMENT ON COLUMN public.geo_data.value IS '值';
COMMENT ON COLUMN public.geo_data.name IS '地点';
COMMENT ON COLUMN public.geo_data.create_at IS '时间戳';
COMMENT ON TABLE public.geo_data IS '坐标数据';