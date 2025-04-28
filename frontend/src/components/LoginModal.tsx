import React from "react";
import { X } from "lucide-react";
import { LoginFormData, LoginModalProps } from "../types";

export function LoginModal({ isOpen, onClose, onLogin }: LoginModalProps) {
  const [formData, setFormData] = React.useState<LoginFormData>({
    email: "",
    password: "",
  });

  if (!isOpen) return null;

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log("Login submitted:", formData);
    onLogin();
    onClose();
  };

  const isFormValid = () => {
    return formData.email.trim() !== "" && formData.password.trim() !== "";
  };

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 p-4">
      <div className="bg-white dark:bg-gray-900 rounded-2xl w-full max-w-md shadow-lg">
        {/* Header */}
        <div className="p-4 border-b border-gray-200 dark:border-gray-700 flex items-center">
          <button
            onClick={onClose}
            className="p-2 hover:bg-gray-100 dark:hover:bg-gray-800 rounded-full"
          >
            <X size={20} className="text-gray-800 dark:text-gray-200" />
          </button>
          <h2 className="text-xl font-bold flex-1 text-center text-gray-900 dark:text-white">
            Log in
          </h2>
          <div className="w-8"></div>
        </div>

        {/* Form */}
        <div className="p-6">
          <form onSubmit={handleSubmit}>
            {/* Floating Email Input */}
            <div className="relative z-0 w-full mb-6 group">
              <input
                type="email"
                name="email"
                id="email"
                value={formData.email}
                onChange={(e) =>
                  setFormData({ ...formData, email: e.target.value })
                }
                className="peer block w-full appearance-none border-0 border-b-2 border-gray-300 dark:border-gray-600 bg-transparent py-2.5 px-0 text-sm text-gray-900 dark:text-white focus:border-blue-600 focus:outline-none focus:ring-0"
                placeholder=""
                required
              />
              <label
                htmlFor="email"
                className="absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-2 left-0 z-10 origin-[0] peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-2.5 peer-placeholder-shown:top-1 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-6"
              >
                Email address
              </label>
            </div>

            {/* Floating Password Input */}
            <div className="relative z-0 w-full mb-6 group">
              <input
                type="password"
                name="password"
                id="password"
                value={formData.password}
                onChange={(e) =>
                  setFormData({ ...formData, password: e.target.value })
                }
                className="peer block w-full appearance-none border-0 border-b-2 border-gray-300 dark:border-gray-600 bg-transparent py-2.5 px-0 text-sm text-gray-900 dark:text-white focus:border-blue-600 focus:outline-none focus:ring-0"
                placeholder=" "
                required
              />
              <label
                htmlFor="password"
                className="absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-2 left-0 z-10 origin-[0] peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-2.5 peer-placeholder-shown:top-2.5 peer-focus:top-2 peer-focus:scale-75 peer-focus:-translate-y-6"
              >
                Password
              </label>
            </div>

            {/* Submit Button */}
            <button
              type="submit"
              disabled={!isFormValid()}
              className="w-full bg-blue-500 text-white rounded-full py-2 font-bold hover:bg-blue-600 transition-colors disabled:opacity-50 disabled:cursor-not-allowed"
            >
              Log in
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
