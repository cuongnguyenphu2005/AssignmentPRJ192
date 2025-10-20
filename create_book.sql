USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Book]    Script Date: 12/07/2025 00:35:36 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Book](
	[book_id] [nchar](15) NOT NULL,
	[book_name] [nvarchar](150) NOT NULL,
	[author] [nvarchar](50) NOT NULL,
	[category] [nvarchar](30) NOT NULL,
	[publisher] [nvarchar](100) NOT NULL,
	[publish_year] [int] NOT NULL,
	[description] [nvarchar](200) NOT NULL,
	[image_url] [nvarchar](200) NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Book] ADD  CONSTRAINT [DF_Book_description]  DEFAULT (N'Processing...') FOR [description]
GO

ALTER TABLE [dbo].[Book] ADD  CONSTRAINT [DF_Book_imageUrl]  DEFAULT (N'img/sample.png') FOR [image_url]
GO


USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Book_Storage]    Script Date: 12/07/2025 00:35:59 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Book_Storage](
	[book_id] [nchar](15) NOT NULL,
	[quantity_available] [int] NOT NULL,
	[status] [bit] NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_Book_Storage_1] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Book_Storage]  WITH CHECK ADD  CONSTRAINT [FK_Book_Storage_Book] FOREIGN KEY([book_id])
REFERENCES [dbo].[Book] ([book_id])
GO

ALTER TABLE [dbo].[Book_Storage] CHECK CONSTRAINT [FK_Book_Storage_Book]
GO


USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Registration]    Script Date: 12/07/2025 00:36:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Registration](
	[username] [nvarchar](50) NOT NULL,
	[password] [varchar](30) NOT NULL,
	[lastname] [nvarchar](100) NOT NULL,
	[isAdmin] [bit] NOT NULL,
 CONSTRAINT [PK_Regis] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[User_Contact]    Script Date: 12/07/2025 00:36:44 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[User_Contact](
	[contact_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[phone] [varchar](15) NOT NULL,
	[address] [nvarchar](255) NOT NULL,
	[email] [varchar](100) NULL,
 CONSTRAINT [PK_User_Contact] PRIMARY KEY CLUSTERED 
(
	[contact_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[User_Contact]  WITH CHECK ADD  CONSTRAINT [FK_User_Contact_Registration] FOREIGN KEY([username])
REFERENCES [dbo].[Registration] ([username])
GO

ALTER TABLE [dbo].[User_Contact] CHECK CONSTRAINT [FK_User_Contact_Registration]
GO


USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Cart]    Script Date: 12/07/2025 00:37:00 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Cart](
	[username] [nvarchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
	[book_id] [nchar](15) NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Book] FOREIGN KEY([book_id])
REFERENCES [dbo].[Book] ([book_id])
GO

ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Book]
GO

ALTER TABLE [dbo].[Cart]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Registration] FOREIGN KEY([username])
REFERENCES [dbo].[Registration] ([username])
GO

ALTER TABLE [dbo].[Cart] CHECK CONSTRAINT [FK_Cart_Registration]
GO


USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Order]    Script Date: 12/07/2025 00:37:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Order](
	[oder_id] [int] IDENTITY(1,1) NOT NULL,
	[contact_id] [int] NOT NULL,
	[order_date] [nchar](20) NOT NULL,
	[status_code] [int] NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[oder_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Status_Order] FOREIGN KEY([status_code])
REFERENCES [dbo].[Status_Order] ([status_code])
GO

ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Status_Order]
GO

ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_User_Contact] FOREIGN KEY([contact_id])
REFERENCES [dbo].[User_Contact] ([contact_id])
GO

ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_User_Contact]
GO


USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Order_Detail]    Script Date: 12/07/2025 00:37:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Order_Detail] (
    [order_id] INT NOT NULL,
    [book_id] NCHAR(15) NOT NULL,
    [quantity] INT NOT NULL,
    [price] FLOAT NOT NULL,
    CONSTRAINT [PK_Order_Detail] PRIMARY KEY CLUSTERED (order_id, book_id)
) ON [PRIMARY];

GO

ALTER TABLE [dbo].[Order_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_Detail_Book1] FOREIGN KEY([book_id])
REFERENCES [dbo].[Book] ([book_id])
GO

ALTER TABLE [dbo].[Order_Detail] CHECK CONSTRAINT [FK_Order_Detail_Book1]
GO

ALTER TABLE [dbo].[Order_Detail]  WITH CHECK ADD  CONSTRAINT [FK_Order_Detail_Order1] FOREIGN KEY([order_id])
REFERENCES [dbo].[Order] ([oder_id])
GO

ALTER TABLE [dbo].[Order_Detail] CHECK CONSTRAINT [FK_Order_Detail_Order1]
GO


USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Status_Order]    Script Date: 12/07/2025 00:38:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Status_Order](
	[status_code] [int] IDENTITY(1,1) NOT NULL,
	[status] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Status_Order] PRIMARY KEY CLUSTERED 
(
	[status_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


