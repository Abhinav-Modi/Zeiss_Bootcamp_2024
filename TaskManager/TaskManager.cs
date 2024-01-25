using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace BugFixTaskManager
{
    public static class TaskManager
    {
        public static void ExecuctePrintTask(IPrinter printer, string documentPath)
        {
            printer.Print(documentPath);
        }
        public static void ExecucteScanTask(IScanner scanner, string documentPath)
        {
            scanner.Scan(documentPath);
        }
    }
}
