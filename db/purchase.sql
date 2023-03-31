PGDMP         -    
            {            online-shop_purchase    15.1    15.2     	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24577    online-shop_purchase    DATABASE     �   CREATE DATABASE "online-shop_purchase" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
 &   DROP DATABASE "online-shop_purchase";
                postgres    false                        2615    24579    purchase    SCHEMA        CREATE SCHEMA purchase;
    DROP SCHEMA purchase;
                postgres    false            �            1255    24651    add_purchase_trigger()    FUNCTION     �   CREATE FUNCTION purchase.add_purchase_trigger() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
	
	NEW.purchase_time = NOW();
	RETURN NEW;
	
END$$;
 /   DROP FUNCTION purchase.add_purchase_trigger();
       purchase          postgres    false    6            �            1259    24589    product_data    TABLE     �   CREATE TABLE purchase.product_data (
    id bigint NOT NULL,
    item text NOT NULL,
    price double precision,
    remark text
);
 "   DROP TABLE purchase.product_data;
       purchase         heap    postgres    false    6                       0    0    TABLE product_data    COMMENT       COMMENT ON TABLE purchase.product_data IS 'id - автоинримент
item - обязательное значение, text, уникальное
price - не обязательное значение, float
remark - не обязательное значение, text';
          purchase          postgres    false    215            �            1259    24620    product_data_id_seq    SEQUENCE     �   ALTER TABLE purchase.product_data ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME purchase.product_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            purchase          postgres    false    6    215            �            1259    24592    purchase_data    TABLE     '  CREATE TABLE purchase.purchase_data (
    id bigint NOT NULL,
    customer_id bigint NOT NULL,
    product_id bigint NOT NULL,
    product_price double precision NOT NULL,
    product_quantity bigint DEFAULT 1 NOT NULL,
    purchase_time timestamp without time zone,
    purchase_remark text
);
 #   DROP TABLE purchase.purchase_data;
       purchase         heap    postgres    false    6                       0    0    TABLE purchase_data    COMMENT     1  COMMENT ON TABLE purchase.purchase_data IS 'id - auto
order time - обязательное поле, без учета часового пояса
customer id - обязательное поле
product id  - обязательное поле
product price - обязательное поле (копирование актуальной цены тк цена может меняться)
product quantity - кол-во товара к заказу, обязательно, по умолчанию 1
purchase remark - не обязательное поле';
          purchase          postgres    false    216            �            1259    24621    purchase_data_id_seq    SEQUENCE     �   ALTER TABLE purchase.purchase_data ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME purchase.purchase_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            purchase          postgres    false    6    216                      0    24589    product_data 
   TABLE DATA           A   COPY purchase.product_data (id, item, price, remark) FROM stdin;
    purchase          postgres    false    215   z                 0    24592    purchase_data 
   TABLE DATA           �   COPY purchase.purchase_data (id, customer_id, product_id, product_price, product_quantity, purchase_time, purchase_remark) FROM stdin;
    purchase          postgres    false    216   �                  0    0    product_data_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('purchase.product_data_id_seq', 1, true);
          purchase          postgres    false    217                       0    0    purchase_data_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('purchase.purchase_data_id_seq', 8, true);
          purchase          postgres    false    218            n           2606    24623    product_data item 
   CONSTRAINT     N   ALTER TABLE ONLY purchase.product_data
    ADD CONSTRAINT item UNIQUE (item);
 =   ALTER TABLE ONLY purchase.product_data DROP CONSTRAINT item;
       purchase            postgres    false    215            p           2606    24607    product_data product_data_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY purchase.product_data
    ADD CONSTRAINT product_data_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY purchase.product_data DROP CONSTRAINT product_data_pkey;
       purchase            postgres    false    215            r           2606    24610     purchase_data purchase_data_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY purchase.purchase_data
    ADD CONSTRAINT purchase_data_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY purchase.purchase_data DROP CONSTRAINT purchase_data_pkey;
       purchase            postgres    false    216            t           2620    24653 #   purchase_data purchase_time_trigger    TRIGGER     �   CREATE TRIGGER purchase_time_trigger BEFORE INSERT ON purchase.purchase_data FOR EACH ROW EXECUTE FUNCTION purchase.add_purchase_trigger();
 >   DROP TRIGGER purchase_time_trigger ON purchase.purchase_data;
       purchase          postgres    false    216    219            s           2606    24636    purchase_data product_data_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY purchase.purchase_data
    ADD CONSTRAINT product_data_fkey FOREIGN KEY (product_id) REFERENCES purchase.product_data(id) NOT VALID;
 K   ALTER TABLE ONLY purchase.purchase_data DROP CONSTRAINT product_data_fkey;
       purchase          postgres    false    3184    216    215               !   x�3�0�¾��xׅ}��1~\1z\\\ �=<         M   x�m��� �7��%�!����(���l�a��v��N%���VcŸZ��]�Y���_I��1���H�UD�1F     