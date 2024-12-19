#### Prerequisites

#### 1. Install Node.js and npm
- Node.js and npm are required to run the Mintlify CLI.    

#### 2. Install Mintlify CLI
- Install the Mintlify CLI globally to manage documentation and generate .mdx files:
  ```bash
  npm i -g mintlify
  ```

#### 1. Generate mdx files for SPI endpoint or new openAPISpec
- Use the following command to create mdx files for the endpoints from the openAPI spec file you have added or made changes to
  ```bash
  npx @mintlify/scraping@latest openapi-file <path-to-openapi-file> -o api-reference
  ```
  **Example:**
  ```bash
  npx @mintlify/scraping@latest openapi-file ./spec/spi/openapi_tax.yml -o api-reference
  ```

#### 2. Add reference to generated endpoint mdx files in navigation section of mint.json

#### 2.1 Locate Generated MDX Files
After running the mdx files generation command, check the api-reference directory for new MDX files.

#### 2.2 Update mint.json Navigation
```json
{
  "navigation": [
    {
      "group": "API Reference",
      "pages": [
        // Existing pages
        "api-reference/existing-endpoint",
        
        // Add your new endpoint MDX file here
        "api-reference/new-endpoint-file"
      ]
    }
  ]
}
```
#### Note
1. Don't use full file paths. Use relative paths.
2. Don't include the .mdx extension.

#### 3. Preview the changes locally
- Run the following command to preview the changes locally
  ```bash
  mintlify dev
  ```