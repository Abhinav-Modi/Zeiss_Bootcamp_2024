using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BugFixTaskManager
{
    public class PrintScanner: IPrinter,IScanner
    {
        private readonly IPrinter printer;
        private readonly IScanner scanner;

        public PrintScanner()
        {
            printer = new Printer();
            scanner = new Scanner();
        }

        public void Print(string path)
        {
            printer.Print(path);
        }

        public void Scan(string path)
        {
            scanner.Scan(path);
        }
    }
}
