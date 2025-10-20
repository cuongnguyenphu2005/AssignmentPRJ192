USE [PRJSE1819]
GO

/****** Object:  Table [dbo].[Book_Storage]    Script Date: 12/07/2025 01:25:46 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Book_Storage](
	[book_id] [nchar](15) NOT NULL,
	[quantity_available] [int] NOT NULL,
	[status] [bit] NOT NULL,
	[price] [int] NOT NULL,
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

USE [PRJSE1819]
GO

-- Loop to insert data for BOOK00001 to BOOK00100
DECLARE @i INT = 1;
WHILE @i <= 100
BEGIN
    DECLARE @book_id NCHAR(15);
    SET @book_id = 'BOOK' + RIGHT('00000' + CAST(@i AS NVARCHAR(5)), 5);

    DECLARE @generated_price INT;

    -- Generate price that ends with 000 and is <= 600000
    -- Step 1: Generate a random number up to 600 (for 600,000)
    -- Step 2: Ensure it's at least 100 (for 100,000)
    -- Step 3: Multiply by 1000 to get the desired format (XXX,000)
    SET @generated_price = (CAST(RAND() * 501 AS INT) + 100) * 1000; -- Random between 100,000 and 600,000, ending in 000

    INSERT INTO [dbo].[Book_Storage]
               ([book_id]
               ,[quantity_available]
               ,[status]
               ,[price])
    VALUES
               (@book_id
               ,ROUND(RAND() * 100 + 100, 0) -- quantity_available: random between 100 and 200
               ,1                            -- status: 1
               ,@generated_price);
    SET @i = @i + 1;
END;
GO

SELECT TOP (1000) [book_id]
      ,[quantity_available]
      ,[status]
      ,[price]
  FROM [PRJSE1819].[dbo].[Book_Storage]

  USE [PRJSE1819]
GO

DELETE FROM [dbo].[Book_Storage]
      
GO