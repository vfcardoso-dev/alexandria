

IF OBJECT_ID('dbo.user', 'U') IS NULL
BEGIN
    CREATE TABLE  [dbo].[user]
	(
		id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
		email VARCHAR(255) NULL,
		enabled BIT NULL,
		[name] VARCHAR(255) NOT NULL,
		[password] VARCHAR(255) NOT NULL,
		[role] VARCHAR(255) NULL,
		[version] DATETIME2(7) NULL
	)
END;

IF OBJECT_ID('dbo.address', 'U') IS NULL
BEGIN
	CREATE TABLE  [dbo].[address]
	(
		id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
		[address] VARCHAR(255) NULL,
		city VARCHAR(255) NOT NULL,
		details VARCHAR(255) NOT NULL,
		[number] VARCHAR(255) NULL,
		postal_code VARCHAR(255) NULL,
		state_province VARCHAR(255) NULL,
		[version] DATETIME2(7) NULL
	)
END;

IF OBJECT_ID('dbo.member', 'U') IS NULL
BEGIN
	CREATE TABLE  [dbo].[member]
	(
		id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
		[name] VARCHAR(255) NULL,
		birth_date DATETIME2(7) NOT NULL,
		email VARCHAR(255) NULL,
		occupation VARCHAR(255) NULL,
		phone VARCHAR(255) NULL,
		registration_number VARCHAR(255) NULL,
		address_id UNIQUEIDENTIFIER NULL,
		[version] DATETIME2(7) NULL
	)
END;

IF (OBJECT_ID('FK_Member_Address_id', 'F') IS NULL)
BEGIN
    ALTER TABLE [dbo].[member]
        ADD CONSTRAINT FK_Member_Address_id FOREIGN KEY(address_id) REFERENCES [dbo].[address](id)
END;


IF OBJECT_ID('dbo.author', 'U') IS NULL
BEGIN
	CREATE TABLE  [dbo].[author]
	(
		id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
		[name] VARCHAR(255) NULL,
		pseudonym VARCHAR(255) NULL,
		last_name VARCHAR(255) NULL
	)
END;

IF OBJECT_ID('dbo.title', 'U') IS NULL
BEGIN
	CREATE TABLE  [dbo].[title]
	(
		id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
		[name] VARCHAR(255) NULL
	)
END;

IF OBJECT_ID('dbo.author_title', 'U') IS NULL
BEGIN
	CREATE TABLE  [dbo].[author_title]
	(
		author_id UNIQUEIDENTIFIER NOT NULL,
		title_id UNIQUEIDENTIFIER NOT NULL

		CONSTRAINT PK_author_title PRIMARY KEY (author_id, title_id)
	)
END;

IF OBJECT_ID('dbo.loan', 'U') IS NULL
BEGIN
	CREATE TABLE  [dbo].[loan]
	(
		id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
		[date] DATETIME2(7) NOT NULL DEFAULT GETDATE(),
		expiring_date DATETIME2(7) NOT NULL,
		return_date DATETIME2(7) NULL,
		copy_id UNIQUEIDENTIFIER NOT NULL,
		member_id UNIQUEIDENTIFIER NOT NULL
	)
END;
IF (OBJECT_ID('FK_Loan_Copy_id', 'F') IS NULL)
BEGIN
    ALTER TABLE [dbo].[loan]
        ADD CONSTRAINT FK_Loan_Copy_id FOREIGN KEY(copy_id) REFERENCES [dbo].[copy](id)
END;
IF (OBJECT_ID('FK_Loan_Member_id', 'F') IS NULL)
BEGIN
    ALTER TABLE [dbo].[loan]
        ADD CONSTRAINT FK_Loan_Member_id FOREIGN KEY(member_id) REFERENCES [dbo].[member](id)
END;

IF OBJECT_ID('dbo.copy', 'U') IS NULL
BEGIN
	CREATE TABLE  [dbo].[copy]
	(
		id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
		[number] int NULL,
		title_id UNIQUEIDENTIFIER NOT NULL
	)
END;
IF (OBJECT_ID('FK_Copy_Title_id', 'F') IS NULL)
BEGIN
    ALTER TABLE [dbo].[copy]
        ADD CONSTRAINT FK_Copy_Title_id FOREIGN KEY(title_id) REFERENCES [dbo].[title](id)
END;





