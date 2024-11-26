import React, { useState } from 'react';

const ExpandableJSONSchema = () => {
  const [isExpanded, setIsExpanded] = useState(false);

  const jsonSchema = `{
   "$schema":"http://json-schema.org/draft-06/schema#",
   "$ref":"#/definitions/ProviderCapabilitySchema",
   "definitions":{
      "ProviderCapabilitySchema":{
         "type":"object",
         ...
      }
   }
}`;

  const fullJsonSchema = `{
   "$schema":"http://json-schema.org/draft-06/schema#",
   "$ref":"#/definitions/ProviderCapabilitySchema",
   "definitions":{
      "ProviderCapabilitySchema":{
         "type":"object",
         "description":"The main schema that defines the structure of both Provider's production and sandbox capabilities.",
         "additionalProperties":false,
         "properties":{
            "prod":{
               "$ref":"#/definitions/CapabilityBody"
            },
            "sandbox":{
               "$ref":"#/definitions/CapabilityBody"
            }
         },
         "required":[
            "prod",
            "sandbox"
         ],
         "title":"ProviderCapabilitySchema"
      },
      // ... rest of the full schema
   }
}`;

  return (
    <div className="w-full border rounded-lg p-4 bg-gray-50">
      <div className="flex items-center justify-between mb-4">
        <h2 className="text-xl font-semibold">Tax Provider JSON Schema</h2>
        <button 
          onClick={() => setIsExpanded(!isExpanded)}
          className="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 transition-colors"
        >
          {isExpanded ? 'Collapse' : 'Expand Full Schema'}
        </button>
      </div>

      <pre className="bg-white border rounded p-3 overflow-x-auto text-sm">
        <code>
          {isExpanded ? fullJsonSchema : jsonSchema + '...'}
        </code>
      </pre>

      {!isExpanded && (
        <div className="mt-2 text-gray-500 italic">
          Click "Expand Full Schema" to see the complete JSON schema
        </div>
      )}
    </div>
  );
};

export default ExpandableJSONSchema;