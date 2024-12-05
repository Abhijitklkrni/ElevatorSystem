#!/bin/bash

# Define the backup directory and file name
BACKUP_DIR="/path/to/backup"
BACKUP_FILE="backup_$(date +%Y%m%d%H%M%S).tar.gz"

# Create the backup directory if it doesn't exist
mkdir -p $BACKUP_DIR

# Archive and compress the files to be backed up
tar -czvf $BACKUP_DIR/$BACKUP_FILE /path/to/files/to/backup

# Print a message indicating the backup is complete
echo "Backup completed: $BACKUP_DIR/$BACKUP_FILE"