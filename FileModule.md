# Get Access to filesystem #

```
phoneGap.getFile().requestFileSystem(FileSystem.LocalFileSystem_PERSISTENT, 0, new FileCallback<FileSystem, FileError>() {

	@Override
	public void onSuccess(FileSystem entry) {
		DirectoryEntry root = entry.getRoot();
		//to something with the directory entry

	}

	@Override
	public void onFailure(FileError error) {
		//oops

	}
});
```


# List Entries in a Directory #

```
DirectoryReader directoryReader = directoryEntry.createReader();
directoryReader.readEntries(new FileCallback<LightArray<EntryBase>, FileError>() {

	@Override
	public void onSuccess(LightArray<EntryBase> entries) {
		for (int i = 0; i < entries.length(); i++) {
			EntryBase entryBase = entries.get(i);

			if (entryBase.isDirectory()) {
				DirectoryEntry directoryEntry = entryBase.getAsDirectoryEntry();
				String name = directoryEntry.getName();
				//do something with the directory
			} else {
				FileEntry fileEntry = entryBase.getAsFileEntry();
				String name = fileEntry.getName();
				//to something with the FileEntry
			}

		}

	}

		@Override
		public void onFailure(FileError error) {
			//oops

		}
});

```

# Read a file #
```
private void readFile(final FileEntry fileEntry) {
	FileReader reader = phoneGap.getFile().createReader();

	reader.setOnloadCallback(new ReaderCallback<FileReader>() {

		@Override
		public void onCallback(FileReader result) {
			String content = result.getResult());
			//do something with the content
		}
	});

	reader.setOnErrorCallback(new ReaderCallback<FileReader>() {

		@Override
		public void onCallback(FileReader result) {
			//error while reading file...

		}
	});

	reader.readAsText(fileEntry);
}
```

# Create a file #
```
private writeFile(DirectoryEntry dirEntry){
	dirEntry.getFile("test.txt", new Flags(true, false), new FileCallback<FileEntry, FileError>() {

		@Override
		public void onSuccess(FileEntry entry) {
			//do something with the file

		}

		@Override
		public void onFailure(FileError error) {
			//oops

		}
});
```

# Write a file #

```
private void writeFile(FileEntry fileEntry){
					
	fileEntry.createWriter(new FileCallback<FileWriter, FileError>() {

		@Override
		public void onSuccess(FileWriter writer) {
				writer.setOnWriteEndCallback(new WriterCallback<FileWriter>() {

					@Override
					public void onCallback(FileWriter result) {
						//file written

					}
				});

				writer.setOnErrorCallback(new WriterCallback<FileWriter>() {

					@Override
					public void onCallback(FileWriter result) {
						//Error while writing file

					}
				});
				writer.write(display.getFileContent().getText());

			}

			@Override
			public void onFailure(FileError error) {
				//can not create writer

			}
	});
```


# file module in dev mode #

In dev mode the phonegap file api is simulated using a gwt remote service. The service **should** only be used in dev mode, because it lets the client manipulate all files under a certain directory.
**Make sure you understand the implication before enabling the service.**
> To use this service you have to add two parameters to your VM Arguments: (Note not the program arguments)

```
-DinsecurePhoneGapFileApi=true
-DphonegapFilePath="path to the directory you want to use"
```

You also have to put this in your web.xml:

```
	<servlet>
		<servlet-name>phonegapfileapi</servlet-name>
		<servlet-class>com.googlecode.gwtphonegap.server.file.FileRemoteServiceServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>phonegapfileapi</servlet-name>
		<url-pattern>/showcase/phonegapfileapi</url-pattern>
	</servlet-mapping>
```