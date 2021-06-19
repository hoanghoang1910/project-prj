CREATE DATABASE Project

CREATE TABLE brands (
    id int identity NOT NULL,
    name nvarchar(200) NOT NULL,
    status int NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE categories (
    id int identity NOT NULL,
    name nvarchar(200) NOT NULL,
    status int NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE products (
    id int identity NOT NULL,
	brand_id int NOT NULL,
	category_id int NOT NULL,
    name nvarchar(200) NOT NULL,
	price float NULL,
	quantity int NOT NULL,
	img_name nvarchar(200) NULL,
	description nvarchar(2000) NULL,
	note nvarchar(200) NULL,
    status int NOT NULL,
    PRIMARY KEY (id),
	CONSTRAINT FK_BrandProduct FOREIGN KEY (brand_id) REFERENCES brands(id),
	CONSTRAINT FK_CategoryProduct FOREIGN KEY (category_id) REFERENCES categories(id),
);

CREATE TABLE accounts(
	id int primary key,
	account nvarchar(200),
	password nvarchar(200),
	displayName nvarchar(200),
	roll nvarchar(100),
);

CREATE TABLE orders(
	id int not null identity(1,1) primary key,
	name nvarchar(200),
	mobile nvarchar(20),
	address nvarchar(200),
	totalPrice float,
	note nvarchar(200),
	status int,
);

CREATE TABLE orders_detail(
	order_id int foreign key references orders(id),
	product_id int,
	name nvarchar(200),
	price float,
	img_name nvarchar(200),
	quantity int,
);


Create table 

SET IDENTITY_INSERT [dbo].[brands] ON 
INSERT [dbo].[brands] ([id], [name], [status]) VALUES (1, N'PETER GREEN', 1)
INSERT [dbo].[brands] ([id], [name], [status]) VALUES (2, N'IKEA', 1)
INSERT [dbo].[brands] ([id], [name], [status]) VALUES (3, N'PARKER KNOLL', 1)
INSERT [dbo].[brands] ([id], [name], [status]) VALUES (4, N'CINTIQUE', 1)
SET IDENTITY_INSERT [dbo].[brands] OFF

SET IDENTITY_INSERT [dbo].[categories] ON 
INSERT [dbo].[categories] ([id], [name], [status]) VALUES (1, N'SOFA', 1)
INSERT [dbo].[categories] ([id], [name], [status]) VALUES (2, N'SEATING', 1)
INSERT [dbo].[categories] ([id], [name], [status]) VALUES (3, N'TABLE', 1)
INSERT [dbo].[categories] ([id], [name], [status]) VALUES (4, N'BED', 1)
INSERT [dbo].[categories] ([id], [name], [status]) VALUES (5, N'MIRROR', 1)
SET IDENTITY_INSERT [dbo].[categories] OFF

SET IDENTITY_INSERT [dbo].[products] ON 
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (1, 1, 1, N'Urban Sofa', 2000, 10, N'sofa1.png', N'The Urban Sofa provides the utmost comfort with its low arms and high back.<br>The addition of a lumbar cushion adds to its ergonomic design.<br>Old Burma Teak legs and base frame give it a stylish finish.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (2, 4, 1, N'Sterling Sofa', 2340, 10, N'sofa2.png', N'The Sterling sofa is an elegant, clean lined design.<br>The combination of leather and upholstery as used in this image<br>gives an interesting detail to a simple silhouette.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (3, 2, 1, N'A La Mode Settee', 4340, 10, N'sofa3.png', N'This three-dimensional gently curved settee is a nod to midcentury modern design.<br>The elegant, comfortable form makes a style statement.<br>The richness of the sofa is emphasised by the six brass legs.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (4, 3, 1, N'Arabesque Sofa', 5340, 10, N'sofa4.png', N'This sofa has intricately carved, curved teak wood panels on the sides.<br>The Art Deco silhouette is the perfect framework for such delicate fretwork<br>Optionally order it with a full fretwork panel and embellish with loose cushions.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (5, 1, 2, N'Spiral Armchair', 600, 10, N'ghe1.jpg', N'This armchair is reminiscent of a spiral staircase with its serpentine back.<br>The design is a throwback to the colonial era.<br>The cane underside adds to the luxurious comfort of the product.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (6, 2, 2, N'Art Deco Moroccan', 800, 10, N'ghe2.jpg', N'This ergonomically designed Art Deco Armchair is generously proportioned.<br> Gently curved teakwood arms sweep upward and create a higher back for perfect lumbar support.<br>Moroccan style fretwork pattern.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (7, 3, 2, N'Modern Slipper Chair', 500, 10, N'ghe3.jpg', N'The frame narrows as it goes upwards, giving it a sleek, light look.<br>The exposed wooden frame and dual panel at the back gives a rich trim.<br>It can be custom ordered with a swivel base.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (8, 4, 3, N'Cigar Table', 1000, 10, N'ban1.jpg', N'A functional padded coffee table that doubles up as an ottoman with removable tray.<br>Special attention has been paid to details like the hand carved turned legs.<br>The perfect solution for today’s relaxed living room or TV room.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (9, 1, 3, N'Plantation Cane', 1400, 10, N'ban2.jpg', N'Two levels for additional surface space.<br>Option of cane, glass, stone and veneer.<br>The veneer top is also available with drawers', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (10, 3, 3, N'Lava Table', 1300, 10, N'ban3.jpg', N'Available in a Round or Oval shape.<br>Monolithic design.<br>Contrasting finish on top and underside.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (11, 2, 3, N'Arabesque Crescent', 1320, 10, N'ban4.jpg', N'The Arabesque Crescent Table is part of our Art Deco Meets Morocco collection.<br>A beautiful Moroccan pattern is etched into the table top, giving the top an interesting detail.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (12, 4, 3, N'Opium Table', 2300, 10, N'ban5.jpg', N'3-way mitered legs.<br>Old Burma Teak base.<br>Woven cane matting top.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (13, 1, 4, N'Hellenic Bed', 10000, 10, N'giuong3.jpg', N'Option of 4 poster and 2 poster.<br>Old Burma Teak.<br>Woven cane matting top.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (14, 2, 4, N'Quilted Trapeze Bed', 12000, 10, N'giuong5.jpg', N'Option of 4 poster and 2 poster.<br>Old Burma Teak.<br>Woven cane matting top.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (15, 3, 4, N'Alita Winged Bed', 11000, 10, N'giuong6.jpg', N'Option of 4 poster and 2 poster.<br>Old Burma Teak.<br>Woven cane matting top.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (16, 4, 4, N'Mayer Bedside Bed', 15000, 10, N'giuong7.jpg', N'Option of 4 poster and 2 poster.<br>Old Burma Teak.<br>Woven cane matting top.', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (17, 4, 5, N'Mosaic Swirl Mirror', 150, 10, N'guong1.jpg', N'Composite leaf with mirror mosaic inlay.<br>Hand carved.<br>Available in round and oval .', N'-', 1)
INSERT [dbo].[products] ([id], [brand_id], [category_id], [name], [price], [quantity], [img_name], [description], [note], [status]) VALUES (18, 2, 5, N'Mosaic Swirl Mirror', 160, 10, N'guong2.jpg', N'Composite leaf with mirror mosaic inlay.<br>Hand carved.<br>Available in round and oval .', N'-', 1)


INSERT [dbo].[accounts] ([id],[account],[password],[displayName],[roll]) VALUES (1, N'Nguyen Tran Hoang','19102001',N'Admin',N'admin')

