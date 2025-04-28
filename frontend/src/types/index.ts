export interface TweetProps {
    id: number;
    author: string;
    handle: string;
    content: string;
    time: string;
    avatar: string;
    likes?: number;
    retweets?: number;
    onLike: (id: number) => void;
    onRetweet: (id: number) => void;
}

export interface TweetModalProps {
    isOpen: boolean;
    onClose: () => void;
}

export interface Tweet {
    id: number;
    author: string;
    handle: string;
    content: string;
    time: string;
    avatar: string;
    likes?: number;
    retweets?: number;
}

export interface LeftSidebarProps {
    className?: string;
    onTweetClick: () => void;
    onPageChange: (page: string) => void;
    currentPage: string;
    onSearch?: (query: string) => void;
}

export interface LoginModalProps {
  isOpen: boolean;
  onClose: () => void;
  onLogin: () => void;
}

export interface LoginFormData {
  email: string;
  password: string;
}

export interface SignupModalProps {
  isOpen: boolean;
  onClose: () => void;
}

export interface SignupFormData {
  step1: {
    name: string;
    email: string;
    birthDate: string;
  };
  step2: {
    username: string;
    password: string;
    bio: string;
  };
}