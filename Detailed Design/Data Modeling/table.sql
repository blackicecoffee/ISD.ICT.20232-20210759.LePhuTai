create table users (
    userid int identity(1,1) primary key,
    username nvarchar(50) not null,
    password nvarchar(100) not null,
    email nvarchar(100) not null,
    phone nvarchar(20),
    role nvarchar(50) not null check (role in ('administrator', 'product manager'))
);

create table product (
    productid int identity(1,1) primary key,
    title nvarchar(100) not null,
    category nvarchar(50) not null,
    value decimal(10, 2) not null,
    currentprice decimal(10, 2) not null,
    barcode nvarchar(50) not null,
    description nvarchar(max),
    quantity int not null,
    warehouseentrydate date not null,
    dimensions nvarchar(50),
    weight decimal(10, 2),
    createdby int,
    updatedby int,
    foreign key (createdby) references users(userid),
    foreign key (updatedby) references users(userid)
);

create table book (
    productid int primary key,
    authors nvarchar(255) not null,
    covertype nvarchar(50) not null check (covertype in ('paperback', 'hardcover')),
    publisher nvarchar(100),
    publicationdate date,
    numberofpages int,
    language nvarchar(50),
    genre nvarchar(50),
    foreign key (productid) references product(productid)
);

create table cd (
    productid int primary key,
    artists nvarchar(255) not null,
    recordlabel nvarchar(100),
    tracklist nvarchar(max),
    genre nvarchar(50),
    releasedate date,
    foreign key (productid) references product(productid)
);

create table lp (
    productid int primary key,
    foreign key (productid) references cd(productid)
);

create table dvd (
    productid int primary key,
    disctype nvarchar(50) not null check (disctype in ('blu-ray', 'hd-dvd')),
    director nvarchar(100),
    runtime time,
    studio nvarchar(100),
    language nvarchar(50),
    subtitles nvarchar(100),
    releasedate date,
    genre nvarchar(50),
    foreign key (productid) references product(productid)
);

create table customer (
    customerid int identity(1,1) primary key,
    name nvarchar(100) not null,
    email nvarchar(100) not null,
    phone nvarchar(20),
    deliveryaddress nvarchar(255) not null,
    deliverycity nvarchar(50) not null,
    createdby int,
    updatedby int,
    foreign key (createdby) references users(userid),
    foreign key (updatedby) references users(userid)
);

create table cart (
    cartid int identity(1,1) primary key,
    customerid int,
    totalpriceexclvat decimal(10, 2),
    totalpriceinclvat decimal(10, 2),
    foreign key (customerid) references customer(customerid)
);

create table cartitem (
    cartitemid int identity(1,1) primary key,
    cartid int,
    productid int,
    quantity int,
    price decimal(10, 2),
    foreign key (cartid) references cart(cartid),
    foreign key (productid) references product(productid)
);

create table orders (
    orderid int identity(1,1) primary key,
    customerid int,
    orderdate datetime not null,
    totalamount decimal(10, 2) not null,
    status nvarchar(50) not null check (status in ('pending', 'approved', 'rejected')),
    foreign key (customerid) references customer(customerid)
);

create table orderitem (
    orderitemid int identity(1,1) primary key,
    orderid int,
    productid int,
    quantity int,
    price decimal(10, 2),
    foreign key (orderid) references orders(orderid),
    foreign key (productid) references product(productid)
);

create table payment (
    paymentid int identity(1,1) primary key,
    orderid int,
    paymentmethod nvarchar(50) not null check (paymentmethod in ('creditcard')),
    transactionid nvarchar(50) not null,
    paymentdate datetime not null,
    amount decimal(10, 2) not null,
    foreign key (orderid) references orders(orderid)
);

create table delivery (
    deliveryid int identity(1,1) primary key,
    orderid int,
    deliverytype nvarchar(50) not null check (deliverytype in ('regular', 'rush')),
    deliveryfee decimal(10, 2) not null,
    deliveryaddress nvarchar(255) not null,
    deliverycity nvarchar(50) not null,
    deliverytime time,
    foreign key (orderid) references orders(orderid)
);

create table vnpaytransaction (
    vnpaytransactionid int identity(1,1) primary key,
    paymentid int,
    vnpaytransactionstatus nvarchar(50) not null check (vnpaytransactionstatus in ('success', 'failure')),
    transactiondate datetime not null,
    foreign key (paymentid) references payment(paymentid)
);
