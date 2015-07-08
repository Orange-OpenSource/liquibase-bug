## Liquibase

### Overview

This files describes how liquibase changelog files are organized.

1. Main config file is db-master-changelog.xml
2. Initial state of the database is described in db-initial-changelog-1.0-full.xml
3. Delta changelog files are stored in delta-changelogs directory
4. All files stored in this directory are loaded in alphabetical order
5. A delta file db-changelog-delta-<number>-<description>.xml is available for each feature, where:
     - <number> is ordering loading number (could be story number by default),
     - <description> is a short description of the feature

