USE [master]
GO
/****** Object:  Database [Cake]    Script Date: 5/29/2020 11:28:17 AM ******/
CREATE DATABASE [Cake]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Cake', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Cake.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Cake_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Cake_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Cake] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Cake].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Cake] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Cake] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Cake] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Cake] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Cake] SET ARITHABORT OFF 
GO
ALTER DATABASE [Cake] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Cake] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Cake] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Cake] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Cake] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Cake] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Cake] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Cake] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Cake] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Cake] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Cake] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Cake] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Cake] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Cake] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Cake] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Cake] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Cake] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Cake] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Cake] SET  MULTI_USER 
GO
ALTER DATABASE [Cake] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Cake] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Cake] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Cake] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Cake] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Cake]
GO
/****** Object:  Table [dbo].[CakeBillCustomer]    Script Date: 5/29/2020 11:28:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CakeBillCustomer](
	[BillID] [nvarchar](50) NOT NULL,
	[CustomerID] [nvarchar](50) NULL,
	[CustomerName] [nchar](10) NULL,
	[CakeIDList] [nvarchar](50) NULL,
	[Total] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CakeIDListCustomer]    Script Date: 5/29/2020 11:28:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CakeIDListCustomer](
	[CakeIDList] [nvarchar](50) NOT NULL,
	[CakeName] [nvarchar](50) NULL,
	[CakeQuantity] [nvarchar](50) NULL,
 CONSTRAINT [PK_CakeIDListCustomer] PRIMARY KEY CLUSTERED 
(
	[CakeIDList] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CakeMenu]    Script Date: 5/29/2020 11:28:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CakeMenu](
	[CakeName] [nvarchar](50) NULL,
	[CakePrice] [int] NULL,
	[CakeID] [nvarchar](50) NULL,
	[CakePicture] [nvarchar](100) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CakeRegistration]    Script Date: 5/29/2020 11:28:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CakeRegistration](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NULL,
	[Role] [nvarchar](50) NULL,
	[EmailAddress] [nvarchar](50) NULL,
	[DateOfBirth] [date] NULL,
	[PhoneNumber] [nchar](15) NULL,
	[UserID] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_CakeRegistration_1] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[CakeBillCustomer] ([BillID], [CustomerID], [CustomerName], [CakeIDList], [Total]) VALUES (N'B01', N'U02', N'haha      ', N'hhsh', N'234234')
INSERT [dbo].[CakeMenu] ([CakeName], [CakePrice], [CakeID], [CakePicture]) VALUES (N'Bánh Mì Bơ Tỏi (10 cm)', 40000, N'C01', N'user/images/banhmibotoisell.jpg')
INSERT [dbo].[CakeMenu] ([CakeName], [CakePrice], [CakeID], [CakePicture]) VALUES (N'Bánh Mì Bơ Tỏi (15cm)', 60000, N'C02', N'user/images/banhmibotoisell.jpg')
INSERT [dbo].[CakeMenu] ([CakeName], [CakePrice], [CakeID], [CakePicture]) VALUES (N'Cheese Cake Oreo (Size S)', 110000, N'C03', N'user/images/cheesecakesell.png')
INSERT [dbo].[CakeMenu] ([CakeName], [CakePrice], [CakeID], [CakePicture]) VALUES (N'Cheese Cake Oreo (Size M)', 240000, N'C04', N'user/images/cheesecakesell.png')
INSERT [dbo].[CakeMenu] ([CakeName], [CakePrice], [CakeID], [CakePicture]) VALUES (N'Tart Cake', 12000, N'C05', N'user/images/tartsell.jpg')
INSERT [dbo].[CakeRegistration] ([Username], [Password], [Fullname], [Role], [EmailAddress], [DateOfBirth], [PhoneNumber], [UserID]) VALUES (N'duy', N'123', N'tathaiduy', N'user', N'tathaiduy@gmail.com', CAST(N'2015-05-03' AS Date), NULL, N'U01')
INSERT [dbo].[CakeRegistration] ([Username], [Password], [Fullname], [Role], [EmailAddress], [DateOfBirth], [PhoneNumber], [UserID]) VALUES (N'haha', N'123', N'hahahaha', N'user', N'haha@gmail.com', CAST(N'1999-02-02' AS Date), NULL, N'U02')
INSERT [dbo].[CakeRegistration] ([Username], [Password], [Fullname], [Role], [EmailAddress], [DateOfBirth], [PhoneNumber], [UserID]) VALUES (N'trinh', N'123', N'ngoctrinh', N'admin', N'ngtring@gmail,com', CAST(N'2001-03-09' AS Date), NULL, N'U03')
USE [master]
GO
ALTER DATABASE [Cake] SET  READ_WRITE 
GO
