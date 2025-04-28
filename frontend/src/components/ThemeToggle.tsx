import { Moon, Sun } from 'lucide-react';
import { useTheme } from '../context/ThemeContext';

export function ThemeToggle() {
  const { theme, toggleTheme } = useTheme();

  return (
    <button
      onClick={toggleTheme}
      className="p-2 hover:bg-gray-100 dark:hover:bg-gray-800 rounded-full"
      aria-label="Toggle theme"
    >
      {theme === 'dark' ? (
        <Sun className="h-5 w-5 text-gray-500 dark:text-gray-400" />
      ) : (
        <Moon className="h-5 w-5 text-gray-500" />
      )}
    </button>
  );
}