PGDMP     -    +    
            {            online-shop_customers    15.1    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24576    online-shop_customers    DATABASE     �   CREATE DATABASE "online-shop_customers" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
 '   DROP DATABASE "online-shop_customers";
                postgres    false                        2615    24578 	   customers    SCHEMA        CREATE SCHEMA customers;
    DROP SCHEMA customers;
                postgres    false            �            1259    24580    customer_data    TABLE     �   CREATE TABLE customers.customer_data (
    id bigint NOT NULL,
    customer_name text NOT NULL,
    customer_surname text NOT NULL,
    customer_email text NOT NULL,
    customer_password text NOT NULL
);
 $   DROP TABLE customers.customer_data;
    	   customers         heap    postgres    false    6                       0    0    TABLE customer_data    COMMENT     T  COMMENT ON TABLE customers.customer_data IS 'id - автоинкримент
customer_name - обязательный параметр
customer_surname - обязательный параметр
customer_email - обязательный параметр, уникально
customer_password -  обязательный параметр';
       	   customers          postgres    false    215            �            1259    24617    customer_data_id_seq    SEQUENCE     �   ALTER TABLE customers.customer_data ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME customers.customer_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
         	   customers          postgres    false    6    215            �            1259    24583    customer_role    TABLE     �   CREATE TABLE customers.customer_role (
    id bigint NOT NULL,
    customer_id bigint NOT NULL,
    role_data_id bigint NOT NULL
);
 $   DROP TABLE customers.customer_role;
    	   customers         heap    postgres    false    6                       0    0    TABLE customer_role    COMMENT     �   COMMENT ON TABLE customers.customer_role IS 'id - авто
customer_id - id заказчика из таблицы customer_data
role_id - роль из таблицы role_data';
       	   customers          postgres    false    216            �            1259    24618    customer_role_id_seq    SEQUENCE     �   ALTER TABLE customers.customer_role ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME customers.customer_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
         	   customers          postgres    false    6    216            �            1259    24586 	   role_data    TABLE     u   CREATE TABLE customers.role_data (
    id bigint NOT NULL,
    role_name text NOT NULL,
    role_description text
);
     DROP TABLE customers.role_data;
    	   customers         heap    postgres    false    6                       0    0    TABLE role_data    COMMENT       COMMENT ON TABLE customers.role_data IS 'id - авто
role_name - обязательный параметр, название роли, уникально
role_description - не обязательный параметр, описание роли, права';
       	   customers          postgres    false    217            �            1259    24619    role_data_id_seq    SEQUENCE     �   ALTER TABLE customers.role_data ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME customers.role_data_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
         	   customers          postgres    false    217    6            
          0    24580    customer_data 
   TABLE DATA           r   COPY customers.customer_data (id, customer_name, customer_surname, customer_email, customer_password) FROM stdin;
 	   customers          postgres    false    215   f                  0    24583    customer_role 
   TABLE DATA           I   COPY customers.customer_role (id, customer_id, role_data_id) FROM stdin;
 	   customers          postgres    false    216   �                  0    24586 	   role_data 
   TABLE DATA           G   COPY customers.role_data (id, role_name, role_description) FROM stdin;
 	   customers          postgres    false    217   �                   0    0    customer_data_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('customers.customer_data_id_seq', 2, true);
       	   customers          postgres    false    218                       0    0    customer_role_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('customers.customer_role_id_seq', 3, true);
       	   customers          postgres    false    219                       0    0    role_data_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('customers.role_data_id_seq', 2, true);
       	   customers          postgres    false    220            q           2606    24605     customer_data customer_data_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY customers.customer_data
    ADD CONSTRAINT customer_data_pkey PRIMARY KEY (id);
 M   ALTER TABLE ONLY customers.customer_data DROP CONSTRAINT customer_data_pkey;
    	   customers            postgres    false    215            s           2606    24616    customer_data customer_email 
   CONSTRAINT     d   ALTER TABLE ONLY customers.customer_data
    ADD CONSTRAINT customer_email UNIQUE (customer_email);
 I   ALTER TABLE ONLY customers.customer_data DROP CONSTRAINT customer_email;
    	   customers            postgres    false    215            u           2606    24614     customer_role customer_role_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY customers.customer_role
    ADD CONSTRAINT customer_role_pkey PRIMARY KEY (id);
 M   ALTER TABLE ONLY customers.customer_role DROP CONSTRAINT customer_role_pkey;
    	   customers            postgres    false    216            w           2606    24612    role_data role_data_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY customers.role_data
    ADD CONSTRAINT role_data_pkey PRIMARY KEY (id);
 E   ALTER TABLE ONLY customers.role_data DROP CONSTRAINT role_data_pkey;
    	   customers            postgres    false    217            y           2606    24625    role_data role_name 
   CONSTRAINT     V   ALTER TABLE ONLY customers.role_data
    ADD CONSTRAINT role_name UNIQUE (role_name);
 @   ALTER TABLE ONLY customers.role_data DROP CONSTRAINT role_name;
    	   customers            postgres    false    217            z           2606    24646     customer_role customer_data_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY customers.customer_role
    ADD CONSTRAINT customer_data_fkey FOREIGN KEY (customer_id) REFERENCES customers.customer_data(id) ON DELETE CASCADE NOT VALID;
 M   ALTER TABLE ONLY customers.customer_role DROP CONSTRAINT customer_data_fkey;
    	   customers          postgres    false    215    3185    216            {           2606    24641    customer_role role_data_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY customers.customer_role
    ADD CONSTRAINT role_data_fkey FOREIGN KEY (role_data_id) REFERENCES customers.role_data(id) ON DELETE RESTRICT NOT VALID;
 I   ALTER TABLE ONLY customers.customer_role DROP CONSTRAINT role_data_fkey;
    	   customers          postgres    false    217    3191    216            
   @   x�3��,K��e�ɥ�%���E����9zE���F�&�\F��%E`I�\H�W� 0?�            x�3�4�4�2�4�4����� #         ;   x�3�tL����L��Q(�/.�L�IUHL.���+�2�t.-.��M-�tJ,�L����� ��,     