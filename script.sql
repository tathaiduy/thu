USE [master]
GO
/****** Object:  Database [AssignmentRentBook]    Script Date: 14/07/2020 10:58:58 SA ******/
CREATE DATABASE [AssignmentRentBook]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'AssignmentRentBook', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\AssignmentRentBook.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'AssignmentRentBook_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\AssignmentRentBook_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [AssignmentRentBook] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AssignmentRentBook].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [AssignmentRentBook] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET ARITHABORT OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AssignmentRentBook] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AssignmentRentBook] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET  DISABLE_BROKER 
GO
ALTER DATABASE [AssignmentRentBook] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AssignmentRentBook] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [AssignmentRentBook] SET  MULTI_USER 
GO
ALTER DATABASE [AssignmentRentBook] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [AssignmentRentBook] SET DB_CHAINING OFF 
GO
ALTER DATABASE [AssignmentRentBook] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [AssignmentRentBook] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [AssignmentRentBook] SET DELAYED_DURABILITY = DISABLED 
GO
USE [AssignmentRentBook]
GO
/****** Object:  Table [dbo].[BookRegistration]    Script Date: 14/07/2020 10:58:58 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookRegistration](
	[BookID] [nvarchar](50) NOT NULL,
	[BookTitle] [nvarchar](50) NULL,
	[BookQuantity] [int] NULL,
	[BookPrice] [nvarchar](50) NULL,
	[BookStatus] [nvarchar](50) NULL,
 CONSTRAINT [PK_Table_2] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 14/07/2020 10:58:58 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderID] [nvarchar](50) NOT NULL,
	[Quantity] [int] NULL,
	[BookID] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderTable]    Script Date: 14/07/2020 10:58:58 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderTable](
	[OrderID] [nvarchar](50) NOT NULL,
	[Date] [nvarchar](50) NULL,
	[Total] [nvarchar](50) NULL,
	[UserID] [nvarchar](50) NULL,
 CONSTRAINT [PK_OrderTable] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserRegistration]    Script Date: 14/07/2020 10:58:58 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRegistration](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NULL,
	[Fullname] [nvarchar](50) NULL,
	[RoleID] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_UserRegistration] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 14/07/2020 10:58:58 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[RoleID] [nvarchar](50) NOT NULL,
	[RoleName] [nvarchar](50) NULL,
 CONSTRAINT [PK_UserRole] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[BookRegistration] ([BookID], [BookTitle], [BookQuantity], [BookPrice], [BookStatus]) VALUES (N'B1', N'XML', 134, N'13000', N'Available')
INSERT [dbo].[BookRegistration] ([BookID], [BookTitle], [BookQuantity], [BookPrice], [BookStatus]) VALUES (N'B2', N'Web', 162, N'15000', N'Available')
INSERT [dbo].[BookRegistration] ([BookID], [BookTitle], [BookQuantity], [BookPrice], [BookStatus]) VALUES (N'B3', N'meow', 123123, N'123', N'Available')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O1', 15, N'B1')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O2', 4, N'B2')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O2', 2, N'B1')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O3', 4, N'B1')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O4', 1, N'B1')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O5', 5, N'B2')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O6', 5, N'B2')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O6', 3, N'B1')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O5', 9, N'B1')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O7', 3, N'B2')
INSERT [dbo].[OrderDetail] ([OrderID], [Quantity], [BookID]) VALUES (N'O7', 4, N'B1')
INSERT [dbo].[OrderTable] ([OrderID], [Date], [Total], [UserID]) VALUES (N'O1', N'12/2/2012', N'15000', N'haha')
INSERT [dbo].[OrderTable] ([OrderID], [Date], [Total], [UserID]) VALUES (N'O2', N'07/20/2020', N'86000', N'user')
INSERT [dbo].[OrderTable] ([OrderID], [Date], [Total], [UserID]) VALUES (N'O3', N'07/27/2020', N'52000', N'user')
INSERT [dbo].[OrderTable] ([OrderID], [Date], [Total], [UserID]) VALUES (N'O4', N'07/14/2020', N'13000', N'user')
INSERT [dbo].[OrderTable] ([OrderID], [Date], [Total], [UserID]) VALUES (N'O5', N'10/14/2020', N'192000', N'user')
INSERT [dbo].[OrderTable] ([OrderID], [Date], [Total], [UserID]) VALUES (N'O6', N'07/21/2020', N'114000', N'haha')
INSERT [dbo].[OrderTable] ([OrderID], [Date], [Total], [UserID]) VALUES (N'O7', N'07/21/2020', N'97000', N'nyduy')
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'admin', N'123', N'haha', N'ad', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'asd', N'asef', N'eswf', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'cfb', N'sdf', N'sdgfg', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'cv', N'wwer', N's', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'derg', N'dfb', N'drg', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'df', N'sdgf', N'sg', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'Duy', N'8719', N'tathaiduy@gmail.com', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'haha', N'123', N'haha', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'littleloveshot', N'8719', N'TrinhDuy', N'us', N'tathaiduy@gmail.com')
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'mlem', N'123', N'12313mjjjhk', N'us', N'tathaiduy@gmail.com')
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'nyduy', N'abcdefgh', N'Người yêu của Duy', N'us', N'littleloveshot@gmail.com')
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'q', N'sf', N'sbfds', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'trinhhh', N'8719', N'Trinh', N'us', N'littleloveshot@gmail.com')
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'user', N'123', N'user', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'vcb', N'asdf', N'sdf', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'xfcv', N'xxdfvv', N'sdef', N'us', NULL)
INSERT [dbo].[UserRegistration] ([Username], [Password], [Fullname], [RoleID], [Email]) VALUES (N'xfg', N'dq', N'sd', N'us', NULL)
INSERT [dbo].[UserRole] ([RoleID], [RoleName]) VALUES (N'ad', N'admin')
INSERT [dbo].[UserRole] ([RoleID], [RoleName]) VALUES (N'us', N'user')
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK__OrderDeta__BookI__37A5467C] FOREIGN KEY([BookID])
REFERENCES [dbo].[BookRegistration] ([BookID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK__OrderDeta__BookI__37A5467C]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_OrderTable] FOREIGN KEY([OrderID])
REFERENCES [dbo].[OrderTable] ([OrderID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_OrderTable]
GO
ALTER TABLE [dbo].[OrderTable]  WITH CHECK ADD  CONSTRAINT [FK__OrderTabl__UserI__398D8EEE] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserRegistration] ([Username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderTable] CHECK CONSTRAINT [FK__OrderTabl__UserI__398D8EEE]
GO
ALTER TABLE [dbo].[UserRegistration]  WITH CHECK ADD  CONSTRAINT [FK__UserRegis__RoleI__1920BF5C] FOREIGN KEY([RoleID])
REFERENCES [dbo].[UserRole] ([RoleID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[UserRegistration] CHECK CONSTRAINT [FK__UserRegis__RoleI__1920BF5C]
GO
USE [master]
GO
ALTER DATABASE [AssignmentRentBook] SET  READ_WRITE 
GO
