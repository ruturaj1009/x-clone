import React from 'react';
import { LeftSidebar } from './components/LeftSidebar';
import { Feed } from './components/Feed';
import { RightSidebar } from './components/RightSidebar';
import { TweetModal } from './components/TweetModal';
import { ExplorePage } from './pages/ExplorePage';
import { NotificationsPage } from './pages/NotificationsPage';
import { ProfilePage } from './pages/ProfilePage';
import { MessagesPage } from './pages/MessagesPage';
import { UpdateProfilePage } from './pages/UpdateProfilePage';
import { ChatPage } from './pages/ChatPage';
import { SearchResultsPage } from './pages/SearchResultsPage';
import { ConnectionsPage } from './pages/ConnectionsPage';
import { LoginPage } from './pages/LoginPage';
import { SubscriptionPage } from './pages/SubscriptionPage';

function App() {
  const [isAuthenticated, setIsAuthenticated] = React.useState(false);
  const [isTweetModalOpen, setIsTweetModalOpen] = React.useState(false);
  const [currentPage, setCurrentPage] = React.useState('home');
  const [selectedChat, setSelectedChat] = React.useState<number | null>(null);
  const [searchQuery, setSearchQuery] = React.useState('');

  if (!isAuthenticated) {
    return (
      <div className="min-h-screen bg-background">
        <LoginPage onLogin={() => setIsAuthenticated(true)} />
      </div>
    );
  }

  const renderPage = () => {
    switch (currentPage) {
      case 'explore':
        return <ExplorePage />;
      case 'notifications':
        return <NotificationsPage />;
      case 'profile':
        return <ProfilePage />;
      case 'messages':
        return <MessagesPage onChatSelect={setSelectedChat} />;
      case 'settings':
        return <UpdateProfilePage />;
      case 'search':
        return <SearchResultsPage />;
      case 'connections':
        return <ConnectionsPage />;
      case 'subscription':
        return <SubscriptionPage />;
      default:
        return <Feed />;
    }
  };

  return (
    <div className="min-h-screen bg-background text-text-primary pb-16 sm:pb-0">
      <div className="container mx-auto flex">
        <LeftSidebar 
          className="w-20 xl:w-1/4 hidden sm:block" 
          onTweetClick={() => setIsTweetModalOpen(true)}
          onPageChange={setCurrentPage}
          currentPage={currentPage}
          onSearch={(query: string) => {
            setSearchQuery(query);
            setCurrentPage('search');
          }}
        />
        <main className="min-h-screen w-full sm:w-[600px] mx-auto border-x border-border">
          {renderPage()}
        </main>
        <RightSidebar />
      </div>
      <TweetModal 
        isOpen={isTweetModalOpen}
        onClose={() => setIsTweetModalOpen(false)}
      />
    </div>
  );
}

export default App;