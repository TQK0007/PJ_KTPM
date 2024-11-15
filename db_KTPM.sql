create database the_wild_oasis;
use the_wild_oasis;

create table if not exists `cabin` (
	`cabin_id` int auto_increment not null primary key,
	`name` nvarchar(100) default null,
    `maxCapacity` int default null,
    `regularPrice` int default null,
    `discount` int default null,
    `image` nvarchar(200) default null,
    `description` nvarchar (1000) default null,
    `created_at` TIMESTAMP default current_timestamp,
	`created_by` varchar(50) default NULL,
	`updated_at` TIMESTAMP DEFAULT NULL,
	`updated_by` varchar(50) DEFAULT NULL
);

insert into `cabin` (`name`,`maxCapacity`,`regularPrice`,`discount`,`image`,`description`)
 values ('001',2,250,0,'http://localhost:31821/Img/cabin-001.jpg','Discover the ultimate luxury getaway for couples in the cozy wooden cabin 001. Nestled in a picturesque forest, this stunning cabin offers a secluded and intimate retreat. Inside, enjoy modern high-quality wood interiors, a comfortable seating area, a fireplace and a fully-equipped kitchen. The plush king-size bed, dressed in fine linens guarantees a peaceful nights sleep. Relax in the spa-like shower and unwind on the private deck with hot tub.'),
		('002',2,350,20,'http://localhost:31821/Img/cabin-002.jpg','Escape to the serenity of nature and indulge in luxury in our cozy cabin 002. Perfect for couples, this cabin offers a secluded and intimate retreat in the heart of a picturesque forest. Inside, you will find warm and inviting interiors crafted from high-quality wood, a comfortable living area, a fireplace and a fully-equipped kitchen. The luxurious bedroom features a plush king-size bed and spa-like shower. Relax on the private deck with hot tub and take in the beauty of nature.'),
		('003',4,300,0,'http://localhost:31821/Img/cabin-003.jpg','Experience luxury family living in our medium-sized wooden cabin 003. Perfect for families of up to 4 people, this cabin offers a comfortable and inviting space with all modern amenities. Inside, you will find warm and inviting interiors crafted from high-quality wood, a comfortable living area, a fireplace, and a fully-equipped kitchen. The bedrooms feature plush beds and spa-like bathrooms. The cabin has a private deck with a hot tub and outdoor seating area, perfect for taking in the natural surroundings.'),
		('004',4,500,50,'http://localhost:31821/Img/cabin-004.jpg','Indulge in the ultimate luxury family vacation in this medium-sized cabin 004. Designed for families of up to 4, this cabin offers a sumptuous retreat for the discerning traveler. Inside, the cabin boasts of opulent interiors crafted from the finest quality wood, a comfortable living area, a fireplace, and a fully-equipped gourmet kitchen. The bedrooms are adorned with plush beds and spa-inspired en-suite bathrooms. Step outside to your private deck and soak in the natural surroundings while relaxing in your own hot tub.'),
		('005',6,350,0,'http://localhost:31821/Img/cabin-005.jpg','Enjoy a comfortable and cozy getaway with your group or family in our spacious cabin 005. Designed to accommodate up to 6 people, this cabin offers a secluded retreat in the heart of nature. Inside, the cabin features warm and inviting interiors crafted from quality wood, a living area with fireplace, and a fully-equipped kitchen. The bedrooms are comfortable and equipped with en-suite bathrooms. Step outside to your private deck and take in the natural surroundings while relaxing in your own hot tub.'),
		('006',6,800,100,'http://localhost:31821/Img/cabin-006.jpg','Experience the epitome of luxury with your group or family in our spacious wooden cabin 006. Designed to comfortably accommodate up to 6 people, this cabin offers a lavish retreat in the heart of nature. Inside, the cabin features opulent interiors crafted from premium wood, a grand living area with fireplace, and a fully-equipped gourmet kitchen. The bedrooms are adorned with plush beds and spa-like en-suite bathrooms. Step outside to your private deck and soak in the natural surroundings while relaxing in your own hot tub.'),
		('007',8,600,100,'http://localhost:31821/Img/cabin-007.jpg','Accommodate your large group or multiple families in the spacious and grand wooden cabin 007. Designed to comfortably fit up to 8 people, this cabin offers a secluded retreat in the heart of beautiful forests and mountains. Inside, the cabin features warm and inviting interiors crafted from quality wood, multiple living areas with fireplace, and a fully-equipped kitchen. The bedrooms are comfortable and equipped with en-suite bathrooms. The cabin has a private deck with a hot tub and outdoor seating area, perfect for taking in the natural surroundings.'),
		('008',10,1400,0,'http://localhost:31821/Img/cabin-008.jpg','Experience the epitome of luxury and grandeur');
        
insert into `cabin` (`cabin_id`,`name`,`maxCapacity`,`regularPrice`,`discount`,`image`,`description`,`created_at`)
values(9,'008',10,1400,0,'http://localhost:31821/Img/cabin-008.jpg','Experience the epitome of luxury and grandeur');

DESCRIBE cabin;

create table if not exists `guests` 
(
	`guest_id` int auto_increment primary key,
	`fullName` nvarchar(100) default null,
	`email` nvarchar(100) default null,
	`nationality` nvarchar(100) default null,
	`nationalID` nvarchar(100) default null,
	`countryFlag` nvarchar(100) default null,
    `created_at` TIMESTAMP default current_timestamp,
	`created_by` varchar(50) default NULL,
	`updated_at` TIMESTAMP DEFAULT NULL,
	`updated_by` varchar(50) DEFAULT NULL
);

insert into `guests` (`fullName`,`email`,`nationality`,`nationalID`,`countryFlag`)
values ('Jonas Schmedtmann','hello@jonas.io','Portugal','3525436345','https://flagcdn.com/pt.svg');

describe guests;

create table if not exists `bookings`
(
	`bookings_id` int auto_increment primary key,
	`cabin_id` int not null,
    `guest_id` int not null,
    `numNights` int default null,
    `numGuests` int default null,
    `cabinPrice` double default null,
    `extrasPrice` double default null,
    `totalPrice` double default null,
    `status` nvarchar(100) default null,
    `hasBreakfast` bool default null,
    `isPaid` bool default null,
    `observations` nvarchar(1000) default null,
    `created_at` TIMESTAMP default current_timestamp,
	`created_by` varchar(50) default NULL,
	`updated_at` TIMESTAMP DEFAULT NULL,
	`updated_by` varchar(50) DEFAULT NULL,
    `startDate` TIMESTAMP default null,
    `endDate` TIMESTAMP default null,
	constraint fk_CabinBookings foreign key (cabin_id) references cabin(cabin_id) on delete cascade,
    constraint fk_GuestsBookings foreign key (guest_id) references guests(guest_id) on delete cascade
);

drop table bookings;

INSERT INTO `bookings` (
    `cabin_id`, `cabinPrice`, `created_at`, `endDate`, `extrasPrice`, 
    `guest_id`, `hasBreakfast`, `isPaid`, `numGuests`, `numNights`, 
    `observations`, `startDate`, `status`, `totalPrice`
)
 VALUES (1, 1750, '2024-10-19T16:53:48.484', '2024-11-15T00:00:00.000', 105, 2, true, false, 1, 7, 'I have a gluten allergy and would like to request a gluten-free breakfast.', '2024-11-08T00:00:00.000', 'unconfirmed', 1855),
		(1, 2500, '2024-10-07T10:34:53.655', '2024-10-27T00:00:00.000', 300, 3, true, true, 2, 10, '', '2024-10-17T00:00:00.000', 'checked-out', 2800),
        (1, 1500, '2024-10-13T10:34:53.655', '2024-11-27T00:00:00.000', 0, 4, false, false, 2, 6, '', '2024-11-21T00:00:00.000', 'unconfirmed', 1500),
        (2, 5200, '2024-09-25T10:34:53.655', '2024-10-11T00:00:00.000', 0, 5, false, true, 2, 16, '', '2024-09-25T00:00:00.000', 'checked-out', 5200),
        (2, 975, '2024-11-07T10:34:53.655', '2024-11-27T00:00:00.000', 90, 6, true, true, 2, 3, '', '2024-11-24T00:00:00.000', 'unconfirmed', 1065),
		(2, 4875, '2024-11-04T10:34:53.656', '2024-12-27T00:00:00.000', 450, 7, true, false, 2, 15, '', '2024-12-12T00:00:00.000', 'unconfirmed', 5325),
		(3, 1500, '2024-09-05T10:34:53.656', '2024-10-20T00:00:00.000', 300, 8, true, true, 4, 5, '', '2024-10-15T00:00:00.000', 'checked-out', 1800),
        (3, 600, '2024-11-07T10:34:53.656', '2024-11-09T00:00:00.000', 0, 9, false, true, 3, 2, 'We will be bringing our small dog with us', '2024-11-07T00:00:00.000', 'checked-in', 600),
		(3, 900, '2024-10-26T10:34:53.656', '2024-10-29T00:00:00.000', 180, 10, true, true, 4, 3, '', '2024-10-26T00:00:00.000', 'checked-out', 1080),
		(4, 5400, '2024-10-10T10:34:53.656', '2024-11-17T00:00:00.000', 720, 11, true, true, 4, 12, '', '2024-11-05T00:00:00.000', 'checked-in', 6120),
		(4, 2250, '2024-11-08T10:34:53.656', '2024-11-26T00:00:00.000', 300, 12, true, false, 4, 5, '', '2024-11-21T00:00:00.000', 'unconfirmed', 2550),
        (4, 450, '2024-11-06T10:34:53.656', '2024-11-28T00:00:00.000', 0, 13, false, true, 1, 1, '', '2024-11-27T00:00:00.000', 'unconfirmed', 450),
		(5, 2450, '2024-11-09T10:34:53.656', '2024-11-30T00:00:00.000', 525, 14, true, false, 5, 7, '', '2024-11-23T00:00:00.000', 'unconfirmed', 2975),
		(5, 700, '2024-11-03T10:34:53.656', '2024-11-05T00:00:00.000', 120, 15, true, true, 4, 2, '', '2024-11-03T00:00:00.000', 'checked-out', 820),
		(5, 1050, '2024-11-05T10:34:53.656', '2024-11-08T00:00:00.000', 0, 16, false, true, 6, 3, '', '2024-11-05T00:00:00.000', 'checked-out', 1050),
		(6, 7700, '2024-11-06T10:34:53.656', '2024-11-20T00:00:00.000', 0, 17, false, true, 6, 11, 'We will be checking in late, around midnight. Hope that\'s okay :)', '2024-11-09T00:00:00.000', 'unconfirmed', 7700),
		(6, 4900, '2024-10-24T10:34:53.656', '2024-10-31T00:00:00.000', 420, 18, true, true, 4, 7, 'I will need a rollaway bed for one of the guests', '2024-10-24T00:00:00.000', 'checked-out', 5320),
		(6, 2100, '2024-10-22T10:34:53.656', '2024-11-08T00:00:00.000', 270, 19, true, true, 6, 3, '', '2024-11-05T00:00:00.000', 'checked-out', 2370),
		(7, 3000, '2024-11-07T10:34:53.656', '2024-12-02T00:00:00.000', 0, 20, false, false, 8, 6, '', '2024-11-26T00:00:00.000', 'unconfirmed', 3000),
		(7, 5000, '2024-11-02T10:34:53.656', '2024-12-29T00:00:00.000', 1050, 21, true, true, 7, 10, '', '2024-12-19T00:00:00.000', 'unconfirmed', 6050),
        (7, 2500, '2024-09-15T10:34:53.656', '2024-12-16T00:00:00.000', 450, 22, true, true, 6, 5, '', '2024-12-11T00:00:00.000', 'unconfirmed', 2950),
		(8, 7000, '2024-11-01T10:34:53.656', '2024-11-09T00:00:00.000', 675, 1, true, true, 9, 5, 'My wife has a gluten allergy so I would like to request a gluten-free breakfast if possible', '2024-11-04T00:00:00.000', 'checked-in', 7675),
		(8, 7000, '2024-11-09T10:34:53.656', '2024-11-14T00:00:00.000', 750, 23, true, true, 10, 5, 'I am celebrating my anniversary, can you arrange for any special amenities or decorations?', '2024-11-09T00:00:00.000', 'unconfirmed', 7750),
		(8, 4200, '2024-10-30T10:34:53.656', '2024-11-22T00:00:00.000', 0, 24, false, true, 7, 3, '', '2024-11-19T00:00:00.000', 'unconfirmed', 4200);




INSERT INTO `bookings` (
    `cabin_id`, `cabinPrice`, `created_at`, `endDate`, `extrasPrice`, 
    `guest_id`, `hasBreakfast`, `isPaid`, `numGuests`, `numNights`, 
    `observations`, `startDate`, `status`, `totalPrice`
)
values (8, 4200, '2024-10-30T10:34:53.656', '2024-11-22T00:00:00.000', 0, 24, false, true, 7, 3, '', '2024-11-19T00:00:00.000', 'unconfirmed', 4200);



describe bookings;

create table if not exists `settings`
(
	`settings_id` int auto_increment primary key,
    `minBookingsLength` int default null,
    `maxBookingsLength` int default null,
    `maxGuestsPerBookings` int default null,
    `breakfastPrice` double default null,
    `created_at` TIMESTAMP default current_timestamp,
	`created_by` varchar(50) default NULL,
	`updated_at` TIMESTAMP DEFAULT NULL,
	`updated_by` varchar(50) DEFAULT NULL
);

insert into `settings`(`minBookingsLength`,`maxBookingsLength`,`maxGuestsPerBookings`,`breakfastPrice`)
values(3,90,8,15);

describe settings;


