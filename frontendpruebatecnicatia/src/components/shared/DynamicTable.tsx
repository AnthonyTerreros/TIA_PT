import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

interface HeaderProps {
  name: string;
  accessKey: string;
}

interface DynamicTableProps<T> {
  headers: HeaderProps[];
  data: T[];
  renderActions?: (item: T) => React.ReactNode;
}

const getNestedValue = (obj: any, path: string): any => {
  return path.split(".").reduce((acc, key) => acc?.[key], obj);
};

export function DynamicTable<T extends Record<string, any>>({
  headers,
  data,
  renderActions,
}: DynamicTableProps<T>) {
  return (
    <div className="border rounded-lg overflow-hidden">
      <Table>
        <TableHeader className="bg-gray-100">
          <TableRow>
            {headers.map((header, index) => (
              <TableHead key={index} className="font-semibold">
                <span className="capitalize">{header.name}</span>
              </TableHead>
            ))}
            {renderActions && (
              <TableHead className="text-center">Acciones</TableHead>
            )}
          </TableRow>
        </TableHeader>

        <TableBody>
          {data.map((row, rowIndex) => (
            <TableRow key={rowIndex} className="hover:bg-gray-50">
              {headers.map((header, colIndex) => (
                <TableCell key={colIndex} className="py-2 px-4 border-b">
                  {getNestedValue(row, header.accessKey)}
                </TableCell>
              ))}
              {renderActions && (
                <TableCell className="py-2 px-4 border-b text-center">
                  {renderActions(row)}
                </TableCell>
              )}
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
}
