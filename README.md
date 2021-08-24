# PEP Identification
The provided solution identifies PEPs based upon two input strings (First name & last name)

## Libraries
To avoid the conversion of file types - Apache POI has been used.

### Apache POI
A library used to read, write and modify Microsoft files - Word, Excel etc.
Defines a Excel .XLSX file as a workbook which is a top level object used to create and read sheets within the workbook.
The sheet contains a grid of cells, each containing text, numbers etc.

### Current apporach
Iterate over all cells in all rows finding inputs matching two adjacent cells.
Returns true if input matches adjacent cells in the sheet, otherwise it returns false.

### Limitations
By entering a empty string input a "Illegal argument exception" is thrown. Proper exception handling needed to mitigate empty inputs.

### Future additions
Format the PEP list by removing schema misdefining rows such as row 1, 3, 24, 44, 45 etc.
- This enables conversion to easier file types such as JSON and CSV for easier data extraction.
